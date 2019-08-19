package com.lucifiere.coder2.resolver.templates.nodes

abstract class TemplatePhaseNode implements Comparable<TemplatePhaseNode> {

    private int startLineNum

    private int endLineNum

    protected String content

    Tuple2<Integer, Integer> getLineNum() {
        return new Tuple2<Integer, Integer>(startLineNum, endLineNum)
    }

    TemplatePhaseNode(int startLineNum, int endLineNum, String content) {
        this.startLineNum = startLineNum
        this.endLineNum = endLineNum
        this.content = content
    }

    @Override
    int compareTo(TemplatePhaseNode o) {
        return this.startLineNum <=> o.getLineNum().first
    }

}
