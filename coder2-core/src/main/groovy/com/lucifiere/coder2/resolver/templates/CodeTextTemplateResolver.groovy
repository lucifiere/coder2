package com.lucifiere.coder2.resolver.templates

import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.resolver.view.CodeFileView
import com.lucifiere.coder2.resolver.view.View

class CodeTextTemplateResolver extends TemplateResolver {

    private String fileName

    CodeTextTemplateResolver(String templatePath, String fileName, BizDataContent bizData) {
        super(templatePath, bizData)
        this.fileName = fileName
    }

    @Override
    View createView(String content) {
        return new CodeFileView(fileName, content)
    }

}
