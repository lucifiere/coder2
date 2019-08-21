package com.lucifiere.coder2.executor.context

import com.lucifiere.coder2.model.TextBizDataSourceContext

import javax.validation.constraints.NotBlank

class CodeFileExecutorContext implements ExecutorContext {

    final String tablePrefix

    @NotBlank
    final String templatePath

    @NotBlank
    final String ddlFilePath

    @NotBlank
    final String generatedFileName

    CodeFileExecutorContext(String tablePrefix, String templatePath, String ddlFilePath, String generatedFileName) {
        this.tablePrefix = tablePrefix
        this.templatePath = templatePath
        this.ddlFilePath = ddlFilePath
        this.generatedFileName = generatedFileName
    }

    String getTablePrefix() {
        return tablePrefix
    }

    String getTemplatePath() {
        return templatePath
    }

    String getDdlFilePath() {
        return ddlFilePath
    }

    String getGeneratedFileName() {
        return generatedFileName
    }

    class Builder<T> {

        /**
         * DDL表前缀
         */
        String tablePrefix

        /**
         * 代码模板位置
         */
        String templatePath

        /**
         * 生成的代码文件的文件名
         */
        String ddlFilePath

        /**
         * 生成的代码文件的文件名
         */
        String generatedFileName

        Builder setTablePrefix(String tablePrefix) {
            this.tablePrefix = tablePrefix
            this
        }

        Builder setTemplatePath(String templatePath) {
            this.templatePath = templatePath
            this
        }

        Builder setDdlFilePath(String ddlFilePath) {
            this.ddlFilePath = ddlFilePath
            this
        }

        Builder setGeneratedFileName(String generatedFileName) {
            this.generatedFileName = generatedFileName
            this
        }

        CodeFileExecutorContext create() {
            return new CodeFileExecutorContext(tablePrefix, templatePath, ddlFilePath, generatedFileName)
        }

    }

    TextBizDataSourceContext toTextBizDataSourceContext() {
        TextBizDataSourceContext sourceContext = new TextBizDataSourceContext()
        sourceContext.setTablePrefix(this.getTablePrefix())
        sourceContext
    }

}
