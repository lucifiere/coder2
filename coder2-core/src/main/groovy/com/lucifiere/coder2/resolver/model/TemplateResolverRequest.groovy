package com.lucifiere.coder2.resolver.model

class TemplateResolverRequest implements ResolverRequest {

    private String templatePath

    private String generateFileName

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
