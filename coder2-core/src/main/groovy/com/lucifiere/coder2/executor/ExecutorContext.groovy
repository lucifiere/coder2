package com.lucifiere.coder2.executor

import com.lucifiere.coder2.model.TextBizDataSourceContext

class ExecutorContext {

    final String tablePrefix

    final String templatePath

    final String ddlFilePath

    final String generatedFileName

    ExecutorContext(String tablePrefix, String templatePath, String ddlFilePath, String generatedFileName) {
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

    class Builder {

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

        ExecutorContext create() {
            return new ExecutorContext(tablePrefix, templatePath, ddlFilePath, generatedFileName)
        }

    }

    TextBizDataSourceContext toTextBizDataSourceContext() {
        TextBizDataSourceContext sourceContext = new TextBizDataSourceContext()
        sourceContext.setTablePrefix(this.getTablePrefix())
        sourceContext
    }

}
