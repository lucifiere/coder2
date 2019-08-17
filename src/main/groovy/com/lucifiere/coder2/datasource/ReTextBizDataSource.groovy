package com.lucifiere.coder2.datasource

import cn.hutool.core.collection.CollectionUtil
import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.helper.TextReader
import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.model.TextBizDataSourceContext

class ReTextBizDataSource extends TextBizDataSource {

    private TextBizDataSourceContext context

    ReTextBizDataSource(TextReader textReader, TextBizDataSourceContext context) {
        super(textReader)
        this.context = context
    }

    @Override
    BizDataContent getContent() {
        assert CollectionUtil.isNotEmpty(super.lines)
        List<List<String>> tokens = []
        super.lines.each { tokens << it.tokenize(StrUtil.SPACE) }
        assert CollectionUtil.isNotEmpty(tokens)

        return null
    }

}
