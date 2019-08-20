package com.lucifiere.coder2.constants

enum FieldType {

    NUM_TINYINT(Short.class, "tinyint", "TINYINT", TemplateVarType.NUMBER),
    NUM_SMALLINT(Integer.class, "smallint", "SMALLINT", TemplateVarType.NUMBER),
    NUM_MEDIUMINT(Integer.class, "mediumint", "INTEGER", TemplateVarType.NUMBER),
    NUM_INT(Integer.class, "int", "INTEGER", TemplateVarType.NUMBER),
    NUM_BIGINT(Long.class, "bigint", "BIGINT", TemplateVarType.NUMBER),
    NUM_FLOAT(Float.class, "float", "FLOAT", TemplateVarType.NUMBER),
    NUM_DOUBLE(Double.class, "double", "DOUBLE", TemplateVarType.NUMBER),
    NUM_DECIMAL(BigDecimal.class, "decimal", "DECIMAL", TemplateVarType.NUMBER),
    TIME_DATE(Date.class, "date", "DATE", TemplateVarType.TIME),
    TIME_DATETIME(Date.class, "datetime", "TIMESTAMP", TemplateVarType.TIME),
    TIME_TIMESTAMP(Date.class, "timestamp", "TIMESTAMP", TemplateVarType.TIME),
    TIME_TIME(Date.class, "time", "TIME", TemplateVarType.TIME),
    STR_CHAR(String.class, "char", "CHAR", TemplateVarType.TEXT),
    STR_VARCHAR(String.class, "varchar", "VARCHAR", TemplateVarType.TEXT),
    STR_TEXT(String.class, "text", "VARCHAR", TemplateVarType.TEXT),
    BYTE_BLOB(Byte[].class, "blob", "BLOB", TemplateVarType.TEXT)

    private Class javaType

    private String sqlLiteral

    private String jdbcType

    private TemplateVarType templateType

    FieldType(Class javaType, String sqlLiteral, String jdbcType, TemplateVarType templateType) {
        this.javaType = javaType
        this.sqlLiteral = sqlLiteral
        this.jdbcType = jdbcType
        this.templateType = templateType
    }

    Class getJavaType() { javaType }

    String getSqlLiteral() { sqlLiteral }

    String getJdbcType() { jdbcType }

    TemplateVarType getTemplateType() { templateType }

    static FieldType findByLiteral(String literal) {
        values().find { it.getSqlLiteral() == literal } as FieldType
    }

}