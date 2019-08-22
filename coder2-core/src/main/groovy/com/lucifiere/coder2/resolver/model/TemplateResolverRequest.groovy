package com.lucifiere.coder2.resolver.model

import com.lucifiere.coder2.model.BizDataContent

class TemplateResolverRequest implements ResolverRequest {

    private BizDataContent bizDataContent

    private String templatePath

    private String generateFileName

    BizDataContent getBizDataContent() {
        return bizDataContent
    }

    void setBizDataContent(BizDataContent bizDataContent) {
        this.bizDataContent = bizDataContent
    }

    String getTemplatePath() {
        return templatePath
    }

    void setTemplatePath(String templatePath) {
        this.templatePath = templatePath
    }

    String getGenerateFileName() {
        return generateFileName
    }

    void setGenerateFileName(String generateFileName) {
        this.generateFileName = generateFileName
    }
}
