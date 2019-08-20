package com.lucifiere.coder2.provider

import com.lucifiere.coder2.datasource.TextDatasource
import com.lucifiere.coder2.model.BizDataContent

class AntlrTextBizDataProvider extends TextBizDataProvider {

    AntlrTextBizDataProvider(TextDatasource textReader) {
        super(textReader)
    }

    @Override
    BizDataContent getContent() {
        return null
    }

}
