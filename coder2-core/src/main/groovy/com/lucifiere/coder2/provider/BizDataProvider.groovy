package com.lucifiere.coder2.provider

import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.provider.model.BizDataRequest

/**
 * 业务数据源
 *
 * @author XD.Wang
 */
interface BizDataProvider {

    BizDataContent getContent(BizDataRequest bizDataRequest)

}
