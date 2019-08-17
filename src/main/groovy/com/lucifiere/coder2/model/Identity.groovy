package com.lucifiere.coder2.model

import cn.hutool.core.util.StrUtil
import org.apache.commons.lang3.StringUtils

class Identity {

    enum NameStyle {
        CAMEL, UNDERLINE
    }

    private String originName

    private String camelName

    private String capitalName

    private String underlineName

    private String alias

    @Override
    String toString() {
        return "Identity{" +
                "originName='" + originName + '\'' +
                ", camelName='" + camelName + '\'' +
                ", capitalName='" + capitalName + '\'' +
                ", underlineName='" + underlineName + '\'' +
                ", alias='" + alias + '\'' +
                '}'
    }

    String getOriginName() {
        return originName
    }

    void setOriginName(String originName) {
        this.originName = originName
    }

    String getCamelName() {
        return camelName
    }

    void setCamelName(String camelName) {
        this.camelName = camelName
    }

    String getCapitalName() {
        return capitalName
    }

    void setCapitalName(String capitalName) {
        this.capitalName = capitalName
    }

    String getUnderlineName() {
        return underlineName
    }

    void setUnderlineName(String underlineName) {
        this.underlineName = underlineName
    }

    String getAlias() {
        return alias
    }

    void setAlias(String alias) {
        this.alias = alias
    }


    static Identity of(String originName, NameStyle nameStyle) {
        switch (nameStyle) {
            case NameStyle.CAMEL: return buildCamelStyleIdentity(originName)
            case NameStyle.UNDERLINE: return buildUnderlineStyleIdentity(originName)
        }
    }

    private static Identity buildCamelStyleIdentity(String originName) {
        Identity identity = new Identity()
        identity.setOriginName(originName)
        if (StrUtil.isNotBlank(originName)) {
            identity.setCamelName(originName)
            String str = originName[0].toLowerCase() + originName[1..-1]
            String underlineStyleName = str.collect { cc -> (cc as char).isUpperCase() ? '_' + cc.toLowerCase() : cc }.join('')
            identity.setUnderlineName(underlineStyleName)
            identity.setCapitalName(com.lucifiere.coder2.utils.StringUtils.capitalFirst(identity.getCamelName()))
        }
        identity
    }

    private static Identity buildUnderlineStyleIdentity(String originName) {
        Identity identity = new Identity()
        identity.setOriginName(originName)
        if (StrUtil.isNotBlank(originName)) {
            identity.setUnderlineName(originName)
            String r = originName.toLowerCase().split('_').collect { cc -> StringUtils.capitalize(cc) }.join('')
            String camelStyleName = r[0].toLowerCase() + r[1..-1]
            identity.setCamelName(camelStyleName)
            identity.setCapitalName(com.lucifiere.coder2.utils.StringUtils.capitalFirst(identity.getCamelName()))
        }
        identity
    }

}