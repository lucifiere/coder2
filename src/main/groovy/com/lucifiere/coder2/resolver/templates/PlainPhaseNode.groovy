package com.lucifiere.coder2.resolver.templates

class PlainPhaseNode extends TemplatePhaseNode {

    PlainPhaseNode(int startLineNum, int endLineNum, String content) {
        super(startLineNum, endLineNum, content)
    }

    @Override
    String render() {
        return null
    }

}
