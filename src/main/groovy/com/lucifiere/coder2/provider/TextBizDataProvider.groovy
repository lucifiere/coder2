package com.lucifiere.coder2.provider

import com.lucifiere.coder2.datasource.TextDatasource

abstract class TextBizDataProvider implements BizDataProvider {

    protected List<String> lines

    TextBizDataProvider(TextDatasource textReader) {
        this.lines = textReader.getText()
    }

}
