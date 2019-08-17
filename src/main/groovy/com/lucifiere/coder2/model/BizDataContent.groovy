package com.lucifiere.coder2.model

/**
 * 业务数据
 *
 * @author XD.Wang
 */
class BizDataContent {

    private Identity identity

    private List<Field> fields

    List<Field> getFields() {
        return fields
    }

    void setFields(List<Field> fields) {
        this.fields = fields
    }


    void setIdentity(String identity) {
        this.identity = Identity.of(identity, Identity.NameStyle.UNDERLINE)
    }

    @Override
    String toString() {
        return "BizDataContent{" +
                "identity='" + identity + '\'' +
                ", fields=" + fields +
                '}'
    }

}
