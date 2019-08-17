package com.lucifiere.coder2.datasource

import cn.hutool.core.collection.CollectionUtil
import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.helper.TextReader
import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.model.Field
import com.lucifiere.coder2.model.TextBizDataSourceContext
import com.lucifiere.coder2.parser.re.ReStatementParser
import com.lucifiere.coder2.parser.re.Statement
import com.lucifiere.coder2.parser.re.Token
import com.lucifiere.coder2.utils.StringUtils

class ReTextBizDataSource extends TextBizDataSource {

    private TextBizDataSourceContext context

    ReTextBizDataSource(TextReader textReader, TextBizDataSourceContext context) {
        super(textReader)
        this.context = context
    }

    @Override
    BizDataContent getContent() {
        assert CollectionUtil.isNotEmpty(super.lines)
        List<List<String>> tokens = []
        super.lines.each { tokens << it.tokenize(StrUtil.SPACE) }
        assert CollectionUtil.isNotEmpty(tokens)
        def statements = []
        lines.each {
            statements << ReStatementParser.createStatement(it)
        }
        // 提取业务数据
        BizDataContent bizDataContent = new BizDataContent()
        String entity = extractEntity(statements)
        bizDataContent.setEntity(entity)
        List<Field> fields = extractFields(statements)
        bizDataContent.setFields(fields)
        bizDataContent
    }

    private String extractEntity(List<Statement> statements) {
        for (Statement statement : statements) {
            for (Token token : statement.getTokens()) {
                def isTableDefStatement = token.getPrev().getContent() == "create" && token.getContent() == "table"
                if (isTableDefStatement) {
                    String simpleTableName = ReStatementParser.extractFiled(token.getNext().getContent())
                    simpleTableName = simpleTableName.replaceFirst(context.getTablePrefix(), StrUtil.EMPTY)
                    return StringUtils.toCamel(simpleTableName)
                }
            }
        }
        null
    }

    private List<Field> extractFields(List<Statement> statements) {
        List<Field> fields = []
        for (Statement statement : statements) {
            if (ReStatementParser.isFiledLine(statement.getLine())) {
                Field field = new Field()
                Token firstContentNode = statement.getTokens().get(1)
                field.setName(ReStatementParser.extractFiled(firstContentNode.getContent()))
                field.setFieldType(ReStatementParser.extractFiledType(firstContentNode.getNext().getContent()))
                field.setLength(ReStatementParser.extractFiledLength(firstContentNode.getNext().getContent(), field.getFieldType()))
                field.setComment(ReStatementParser.extractFiledComment(statement))
                fields << field
            }
        }
        fields
    }

}
