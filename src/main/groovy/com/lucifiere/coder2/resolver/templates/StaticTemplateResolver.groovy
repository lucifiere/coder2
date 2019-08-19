package com.lucifiere.coder2.resolver.templates

import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.datasource.FileTextReader
import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.resolver.Resolver

class StaticTemplateResolver implements Resolver {

    final static String FILED_BEGIN = ">>>"

    final static String FILED_END = "<<<"

    private FileTextReader fileTextReader

    StaticTemplateResolver(String templatePath) {
        fileTextReader = new FileTextReader(templatePath)
    }

    @Override
    String render(BizDataContent c) {
        List<String> templates = fileTextReader.getText()
        List<TemplatePhaseNode> nodes = createTemplatePhaseNodes(templates)
        nodes.sort()
        return null
    }

    private static List<TemplatePhaseNode> createTemplatePhaseNodes(List<String> content) {
        List<TemplatePhaseNode> nodes = []
        extractFieldPhaseNodes(content).each { nodes << it }
        extractPlainPhaseNodes(content).each { nodes << it }
    }

    private static List<TemplatePhaseNode> extractFieldPhaseNodes(List<String> lines) {
        extractPhaseNodes(lines, { line -> line == FILED_BEGIN }, { line -> line == FILED_END })
    }

    private static List<TemplatePhaseNode> extractPlainPhaseNodes(List<String> lines) {
        extractPhaseNodes(lines, { line -> line != FILED_BEGIN }, { line -> line == FILED_BEGIN })
    }

    private static List<TemplatePhaseNode> extractPhaseNodes(List<String> lines, Closure<Boolean> startMatching, Closure<Boolean> endMatching) {
        boolean matching = true
        int matchedStartLine = 1, lineNum = 1
        List<TemplatePhaseNode> nodes = []
        String matchedStr = StrUtil.EMPTY
        for (int i = 1; i <= lines.size(); i++) {
            String cur = lines[i - 1]
            if (startMatching.call(cur)) {
                matching = false; continue
            }
            if (endMatching.call(cur)) {
                matching = true; continue
            }
            if (matching) {
                matchedStartLine = i
                matchedStr += cur
            } else if (StrUtil.isNotBlank(matchedStr)) {
                nodes << new FieldPhaseNode(matchedStartLine, i, matchedStr)
                matchedStr = StrUtil.EMPTY
            }
            lineNum++
        }
        nodes
    }

}
