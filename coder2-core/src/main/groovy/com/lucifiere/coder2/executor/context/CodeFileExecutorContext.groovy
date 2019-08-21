package com.lucifiere.coder2.executor.context

import com.lucifiere.coder2.model.TextBizDataSourceContext

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class CodeFileExecutorContext<T> implements ExecutorContext {

    final String tablePrefix

    @NotBlank
    final String templatePath

    @NotBlank
    final String ddlFilePath

    @NotBlank
    final String generatedFileName

    @NotNull
    final Class<T> executorClazz

    @NotBlank
    final String name

    CodeFileExecutorContext(String tablePrefix, String templatePath, String ddlFilePath, String generatedFileName, Class<T> executorClazz, String executorName) {
        this.tablePrefix = tablePrefix
        this.templatePath = templatePath
        this.ddlFilePath = ddlFilePath
        this.generatedFileName = generatedFileName
        this.executorClazz = executorClazz
        this.name = executorName
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

    Class<T> getExecutorClazz() {
        return executorClazz
    }

    String getName() {
        return name
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

        /**
         * 执行器类型
         */
        Class<T> executorClazz

        /**
         * 执行器名称
         */
        String name

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

        Builder setExecutorClazz(Class<T> executorClazz) {
            this.executorClazz = executorClazz
            this
        }

        Builder setName(String executorName) {
            this.name = executorName
            this
        }

        CodeFileExecutorContext create() {
            return new CodeFileExecutorContext(tablePrefix, templatePath, ddlFilePath, generatedFileName, executorClazz, name)
        }

    }

    TextBizDataSourceContext toTextBizDataSourceContext() {
        TextBizDataSourceContext sourceContext = new TextBizDataSourceContext()
        sourceContext.setTablePrefix(this.getTablePrefix())
        sourceContext
    }

}
