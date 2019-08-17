package com.lucifiere.coder2.model

/**
 * 业务数据
 *
 * @author XD.Wang
 */
class BizDataContent {

    private String entity

    private List<Field> fields

    String getEntity() {
        return entity
    }

    void setEntity(String entity) {
        this.entity = entity
    }

    List<Field> getFields() {
        return fields
    }

    void setFields(List<Field> fields) {
        this.fields = fields
    }
}
