package com.lucifiere.coder2.resolver.templates

import com.lucifiere.coder2.provider.BizDataProvider
import com.lucifiere.coder2.resolver.view.CodeFileView
import com.lucifiere.coder2.resolver.view.View

class CodeTextTemplateResolver extends TemplateResolver {

    private String fileName

    CodeTextTemplateResolver(String templatePath, String fileName, BizDataProvider provider) {
        super(templatePath, provider)
        this.fileName = fileName
    }

    @Override
    View createView(String content) {
        return new CodeFileView(fileName, content)
    }

}
