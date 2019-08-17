package com.lucifiere.coder2.datasource

import com.lucifiere.coder2.helper.TextReader

abstract class TextBizDataSource implements BizDataSource {

    protected List<String> lines

    TextBizDataSource(TextReader textReader) {
        this.lines = textReader.getText()
    }

}
