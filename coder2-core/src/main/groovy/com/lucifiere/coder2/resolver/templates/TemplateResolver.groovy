package com.lucifiere.coder2.resolver.templates

import cn.hutool.core.util.ObjectUtil
import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.model.Field
import com.lucifiere.coder2.provider.parser.re.RePattern
import com.lucifiere.coder2.resolver.Resolver
import com.lucifiere.coder2.resolver.templates.constants.TemplateKeywords
import com.lucifiere.coder2.resolver.templates.nodes.FieldPhaseNode
import com.lucifiere.coder2.resolver.templates.nodes.PlainPhaseNode
import com.lucifiere.coder2.resolver.templates.nodes.TemplatePhaseNode
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.expression.ExpressionParser
import org.springframework.expression.spel.standard.SpelExpressionParser

import java.util.stream.Collectors

abstract class TemplateResolver implements Resolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateResolver.class)

    final ExpressionParser elParser = new SpelExpressionParser()

    final BizDataContent bizData

    TemplateResolver(BizDataContent bizData) {
        this.bizData = bizData
    }

    protected String renderNodes(List<TemplatePhaseNode> nodes) {
        nodes.stream().map {
            this.render(it)
        }.collect(Collectors.joining(StrUtil.EMPTY))
    }

    String render(FieldPhaseNode fieldPhaseNode) {
        List nodeAfterSpread = spreadFieldPhaseNode(fieldPhaseNode)
        nodeAfterSpread.each {
            resolveTemplateKeywords(it as FieldPhaseNode)
            resolveSpEL(it)
        }
        nodeAfterSpread.stream().map { it.getContent() }.collect(Collectors.joining())
    }

    String render(PlainPhaseNode fieldPhaseNode) {
        fieldPhaseNode.each {
            resolveTemplateKeywords(it as PlainPhaseNode)
            resolveSpEL(it)
        }
        fieldPhaseNode.getContent()
    }

    List<FieldPhaseNode> spreadFieldPhaseNode(FieldPhaseNode fieldPhaseNode) {
        List<Field> fields = bizData.getFields()
        fields.stream().map {
            FieldPhaseNode node = ObjectUtil.cloneByStream(fieldPhaseNode as FieldPhaseNode)
            node.setFiled(it)
            node
        }.collect(Collectors.toList())
    }

    void resolveTemplateKeywords(TemplatePhaseNode node) {
        if (node instanceof PlainPhaseNode) {
            String content = node.getContent()
            content = content.replaceAll(TemplateKeywords.IDENTITY_CAMEL, bizData.identity.camelName)
                    .replaceAll(TemplateKeywords.IDENTITY_CAPITAL_FIRST, bizData.identity.capitalName)
                    .replaceAll(TemplateKeywords.IDENTITY_UNDERLINE, bizData.identity.underlineName)
            node.setContent(content)
        }
        if (node instanceof FieldPhaseNode) {
            String content = node.getContent()
            Field field = node.getFiled()
            content = content.replaceAll(TemplateKeywords.FIELD_CAMEL, field.identity.camelName)
                    .replaceAll(TemplateKeywords.FIELD_CAPITAL_FIRST, bizData.identity.capitalName)
                    .replaceAll(TemplateKeywords.FIELD_UNDERLINE, bizData.identity.underlineName)
                    .replaceAll(TemplateKeywords.FIELD_TYPE, field.getFieldType().javaType.simpleName)
                    .replaceAll(TemplateKeywords.FIELD_COMMENT, field.getComment())
            node.setContent(content)
        }
    }

    void resolveSpEL(TemplatePhaseNode templatePhaseNode) {
        String content = templatePhaseNode.getContent()
        content = content.replaceAll(RePattern.SPEL_PAT, {
            String elStr = it as String
            try {
                String el = elStr.substring(1, elStr.length() - 1)
                return el
//                Expression result = elParser.parseExpression(el)
//                return result.getValue(String.class)
            } catch (Exception e) {
                LOGGER.error("analysis spring el failed!", e)
                return elStr
            }
        })
        templatePhaseNode.setContent(content)
    }

}
