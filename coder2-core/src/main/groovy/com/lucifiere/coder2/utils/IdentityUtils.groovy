package com.lucifiere.coder2.utils

import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.model.Identity

class IdentityUtils {

    static Identity buildCamelStyleIdentity(String originName) {
        Identity identity = new Identity()
        identity.setOriginName(originName)
        if (StrUtil.isNotBlank(originName)) {
            identity.setCamelName(originName)
            String str = originName[0].toLowerCase() + originName[1..-1]
            String underlineStyleName = str.collect { cc -> (cc as char).isUpperCase() ? '_' + cc.toLowerCase() : cc }.join('')
            identity.setUnderlineName(underlineStyleName)
            identity.setCapitalName(StringUtils.capitalFirst(identity.getCamelName()))
        }
        identity
    }

    static Identity buildUnderlineStyleIdentity(String originName) {
        Identity identity = new Identity()
        identity.setOriginName(originName)
        if (StrUtil.isNotBlank(originName)) {
            identity.setUnderlineName(originName)
            String r = originName.toLowerCase().split('_').collect { cc -> org.apache.commons.lang3.StringUtils.capitalize(cc) }.join('')
            String camelStyleName = r[0].toLowerCase() + r[1..-1]
            identity.setCamelName(camelStyleName)
            identity.setCapitalName(StringUtils.capitalFirst(identity.getCamelName()))
        }
        identity
    }

}
