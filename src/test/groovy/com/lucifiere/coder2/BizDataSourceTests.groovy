package com.lucifiere.coder2

import com.lucifiere.coder2.datasource.BizDataSource
import com.lucifiere.coder2.datasource.ReTextBizDataSource
import com.lucifiere.coder2.helper.FileTextReader
import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.model.TextBizDataSourceContext
import org.junit.Test

class BizDataSourceTests {

    @Test
    void testBizDataExtract() {
        TextBizDataSourceContext context = new TextBizDataSourceContext()
        context.setTablePrefix("coupon_")
        BizDataSource bizDataSource = new ReTextBizDataSource(new FileTextReader("src/test/resources/coupon_template_rule.sql"), context)
        BizDataContent bizDataContent = bizDataSource.getContent()
        println bizDataContent
    }

}
