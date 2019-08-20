package com.lucifiere.coder2.model

import com.lucifiere.coder2.utils.IdentityUtils

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
            case NameStyle.CAMEL: return IdentityUtils.buildCamelStyleIdentity(originName)
            case NameStyle.UNDERLINE: return IdentityUtils.buildUnderlineStyleIdentity(originName)
        }
    }

}