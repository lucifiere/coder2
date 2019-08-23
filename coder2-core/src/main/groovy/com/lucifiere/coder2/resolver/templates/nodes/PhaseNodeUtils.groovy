package com.lucifiere.coder2.resolver.templates.nodes

import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.resolver.templates.constants.TemplateKeywords

class PhaseNodeUtils {

    static List<TemplatePhaseNode> createTemplatePhaseNodes(List<String> content) {
        List<TemplatePhaseNode> nodes = []
        extractFieldPhaseNodes(content).each { nodes << it }
        extractPlainPhaseNodes(content).each { nodes << it }
        nodes.sort()
    }

    private static List<TemplatePhaseNode> extractPlainPhaseNodes(List<String> lines) {
        extractPhaseNodes(lines, { line -> line == TemplateKeywords.FILED_BEGIN },
                { line -> line == TemplateKeywords.FILED_END }, { s, e, c -> new PlainPhaseNode(s as int, e as int, c as String) })
    }

    private static List<TemplatePhaseNode> extractFieldPhaseNodes(List<String> lines) {
        extractPhaseNodes(lines, { line -> line != TemplateKeywords.FILED_BEGIN },
                { line -> line == TemplateKeywords.FILED_BEGIN }, { s, e, c -> new FieldPhaseNode(s as int, e as int, c as String) })
    }

    private static List<TemplatePhaseNode> extractPhaseNodes(List<String> lines, Closure<Boolean> startMatching, Closure<Boolean> endMatching, Closure<TemplatePhaseNode> supplier) {
        boolean matching = true
        int matchedStartLine = 1, lineNum = 1
        List<TemplatePhaseNode> nodes = []
        String matchedStr = StrUtil.EMPTY
        for (int i = 1; i <= lines.size(); i++) {
            String cur = lines[i - 1]
            if (startMatching.call(cur)) {
                matchedStartLine = i
                matching = false; continue
            }
            if (endMatching.call(cur)) {
                matching = true; continue
            }
            if (matching) {
                matchedStr += cur + "\n"
            } else if (StrUtil.isNotBlank(matchedStr)) {
                nodes << supplier.call(matchedStartLine, i, matchedStr)
                matchedStr = StrUtil.EMPTY
            }
            // 如果到最后一行了 那么就直接返回结果
            if (lineNum == lines.size()) {
                nodes << supplier.call(matchedStartLine, i, matchedStr)
            }
            lineNum++
        }
        nodes
    }

}
