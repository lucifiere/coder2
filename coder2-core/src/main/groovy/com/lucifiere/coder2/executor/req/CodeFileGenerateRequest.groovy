package com.lucifiere.coder2.executor.req

import com.lucifiere.coder2.model.TextBizDataSourceContext

import javax.validation.constraints.NotBlank

class CodeFileGenerateRequest implements ExecutorRequest {

    private final String tablePrefix

    @NotBlank
    private final String ddlFilePath

    String getTablePrefix() {
        return tablePrefix
    }

    String getDdlFilePath() {
        return ddlFilePath
    }

    CodeFileGenerateRequest(String tablePrefix, String ddlFilePath) {
        this.tablePrefix = tablePrefix
        this.ddlFilePath = ddlFilePath
    }

    static class Builder {

        /**
         * DDL表前缀
         */
        String tablePrefix

        /**
         * 生成的代码文件的文件名
         */
        String ddlFilePath

        Builder setTablePrefix(String tablePrefix) {
            this.tablePrefix = tablePrefix
            this
        }

        Builder setDdlFilePath(String ddlFilePath) {
            this.ddlFilePath = ddlFilePath
            this
        }

        CodeFileGenerateRequest create() {
            return new CodeFileGenerateRequest(tablePrefix, ddlFilePath)
        }

    }

    TextBizDataSourceContext toTextBizDataSourceContext() {
        TextBizDataSourceContext sourceContext = new TextBizDataSourceContext()
        sourceContext.setTablePrefix(this.getTablePrefix())
        sourceContext
    }

}
