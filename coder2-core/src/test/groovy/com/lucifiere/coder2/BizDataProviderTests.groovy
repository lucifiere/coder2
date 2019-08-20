package com.lucifiere.coder2

import com.lucifiere.coder2.datasource.FileTextReader
import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.model.TextBizDataSourceContext
import com.lucifiere.coder2.provider.BizDataProvider
import com.lucifiere.coder2.provider.ReTextBizDataProvider
import org.junit.Test

class BizDataProviderTests {

    @Test
    void testBizDataExtract() {
        TextBizDataSourceContext context = new TextBizDataSourceContext()
        context.setTablePrefix("coupon_")
        BizDataProvider bizDataSource = new ReTextBizDataProvider(new FileTextReader("src/test/resources/coupon_template_rule.sql"), context)
        BizDataContent bizDataContent = bizDataSource.getContent()
        println bizDataContent
    }

}
