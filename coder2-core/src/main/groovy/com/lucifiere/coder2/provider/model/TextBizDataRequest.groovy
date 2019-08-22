package com.lucifiere.coder2.provider.model

class TextBizDataRequest implements BizDataRequest {

    private String tablePrefix

    private String textFilePath

    String getTablePrefix() {
        return tablePrefix
    }

    void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix
    }

    String getTextFilePath() {
        return textFilePath
    }

    void setTextFilePath(String textFilePath) {
        this.textFilePath = textFilePath
    }
}