package com.lucifiere.coder2.resolver.templates

import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.datasource.FileTextReader
import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.resolver.Resolver
import com.lucifiere.coder2.resolver.templates.nodes.FieldPhaseNode
import com.lucifiere.coder2.resolver.templates.nodes.PhaseNodeUtils
import com.lucifiere.coder2.resolver.templates.nodes.PlainPhaseNode
import com.lucifiere.coder2.resolver.templates.nodes.TemplatePhaseNode
import org.springframework.expression.spel.standard.SpelExpressionParser

import java.util.stream.Collectors

class StaticTemplateResolver implements Resolver {

    final private FileTextReader fileTextReader

    final private BizDataContent bizDataContent

    final private ExpressionParser = new SpelExpressionParser()

    StaticTemplateResolver(String templatePath, BizDataContent bizDataContent) {
        this.fileTextReader = new FileTextReader(templatePath)
        this.bizDataContent = bizDataContent
    }

    @Override
    String resolve() {
        List<String> templates = fileTextReader.getText()
        List<TemplatePhaseNode> nodes = PhaseNodeUtils.createTemplatePhaseNodes(templates)
        nodes = nodes.sort()
        return renderNodes(nodes)
    }

    private String renderNodes(List<TemplatePhaseNode> nodes) {
        nodes.stream().map { this.render(it) }.collect(Collectors.joining(StrUtil.EMPTY))
    }

    private String render(FieldPhaseNode fieldPhaseNode) {

    }

    private String render(PlainPhaseNode fieldPhaseNode) {

    }

}
