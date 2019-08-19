package com.lucifiere.coder2.model

import com.lucifiere.coder2.constants.FieldType

class Field {

    private FieldType fieldType

    private Identity identity

    private Integer length

    private String comment

    FieldType getFieldType() {
        return fieldType
    }

    void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType
    }

    Identity getIdentity() {
        return identity
    }

    void setIdentity(String identity) {
        this.identity = Identity.of(identity, Identity.NameStyle.UNDERLINE)
    }

    Integer getLength() {
        return length
    }

    void setLength(Integer length) {
        this.length = length
    }

    String getComment() {
        return comment
    }

    void setComment(String comment) {
        this.comment = comment
    }

}
