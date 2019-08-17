package com.lucifiere.coder2.model

import com.lucifiere.coder2.constants.FieldType

class Field {

    private FieldType fieldType

    private Identity name

    private Integer length

    private String comment

    FieldType getFieldType() {
        return fieldType
    }

    void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType
    }

    void setName(String name) {
        this.name = Identity.of(name, Identity.NameStyle.UNDERLINE)
    }

    String getSqlName() {
        return sqlName
    }

    void setSqlName(String sqlName) {
        this.sqlName = sqlName
    }

    String getJavaName() {
        return javaName
    }

    void setJavaName(String javaName) {
        this.javaName = javaName
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
