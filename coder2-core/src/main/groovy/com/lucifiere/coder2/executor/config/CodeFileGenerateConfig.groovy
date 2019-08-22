package com.lucifiere.coder2.executor.config

import javax.validation.constraints.NotBlank

class CodeFileGenerateConfig implements ExecutorConfig {

    @NotBlank
    private final String templatePath

    @NotBlank
    private final String generatedFileName

    String getTemplatePath() {
        return templatePath
    }

    String getGeneratedFileName() {
        return generatedFileName
    }

    CodeFileGenerateConfig(String templatePath, String generatedFileName) {
        this.templatePath = templatePath
        this.generatedFileName = generatedFileName
    }

    class Builder<T> {

        /**
         * 代码模板位置
         */
        String templatePath

        /**
         * 生成的代码文件的文件名
         */
        String generatedFileName

        Builder setTemplatePath(String templatePath) {
            this.templatePath = templatePath
            this
        }

        Builder setGeneratedFileName(String generatedFileName) {
            this.generatedFileName = generatedFileName
            this
        }

        CodeFileGenerateConfig create() {
            return new CodeFileGenerateConfig(templatePath, generatedFileName)
        }

    }

}
