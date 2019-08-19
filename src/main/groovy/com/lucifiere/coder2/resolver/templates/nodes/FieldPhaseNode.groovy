package com.lucifiere.coder2.resolver.templates.nodes

import com.lucifiere.coder2.model.Field

class FieldPhaseNode extends TemplatePhaseNode {

    private Field filed

    FieldPhaseNode(int startLineNum, int endLineNum, String content) {
        super(startLineNum, endLineNum, content)
    }

    Field getFiled() {
        return filed
    }

    void setFiled(Field filed) {
        this.filed = filed
    }
}
