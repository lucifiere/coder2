package com.lucifiere.coder2.provider

import cn.hutool.core.collection.CollectionUtil
import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.constants.MySqlKeywords
import com.lucifiere.coder2.datasource.FileTextReader
import com.lucifiere.coder2.model.BizDataContent
import com.lucifiere.coder2.model.Field
import com.lucifiere.coder2.provider.model.BizDataRequest
import com.lucifiere.coder2.provider.model.TextBizDataRequest
import com.lucifiere.coder2.provider.parser.re.ReStatementParser
import com.lucifiere.coder2.provider.parser.re.Statement
import com.lucifiere.coder2.provider.parser.re.Token

import java.util.stream.Collectors

class ReTextBizDataProvider extends TextBizDataProvider {

    ReTextBizDataProvider() {
    }

    @Override
    BizDataContent getContent(BizDataRequest bizDataRequest) {
        TextBizDataRequest textBizDataRequest = bizDataRequest as TextBizDataRequest
        FileTextReader fileTextReader = new FileTextReader(textBizDataRequest.getTextFilePath())
        super.lines = fileTextReader.getText()
        assert CollectionUtil.isNotEmpty(super.lines)
        List<List<String>> tokens = []
        super.lines.each { tokens << it.tokenize(StrUtil.SPACE) }
        assert CollectionUtil.isNotEmpty(tokens)
        List<Statement> statements = lines.stream().map {
            ReStatementParser.createStatement(it)
        }.filter { Objects.nonNull(it) }.collect(Collectors.toList())
        // 提取业务数据
        BizDataContent bizDataContent = new BizDataContent()
        String tableName = extractSimpleTableName(statements, textBizDataRequest.getTablePrefix())
        bizDataContent.setIdentity(tableName)
        List<Field> fields = extractFields(statements)
        bizDataContent.setFields(fields)
        bizDataContent
    }

    private static String extractSimpleTableName(List<Statement> statements, String tablePrefix) {
        for (Statement statement : statements) {
            for (Token token : statement.getTokens()) {
                def isTableDefStatement = token != null && token.getPrev() != null && StrUtil.equals(token.getPrev().getContent(), MySqlKeywords.CREATE, true) && StrUtil.equals(token.getContent(), MySqlKeywords.TABLE, true)
                if (isTableDefStatement) {
                    String simpleTableName = ReStatementParser.extractFiled(token.getNext().getContent())
                    simpleTableName = simpleTableName.replaceFirst(tablePrefix, StrUtil.EMPTY)
                    return simpleTableName
                }
            }
        }
        null
    }

    private static List<Field> extractFields(List<Statement> statements) {
        List<Field> fields = []
        for (Statement statement : statements) {
            if (CollectionUtil.isEmpty(statement.getTokens())) continue
            Token firstContentNode = statement.getTokens().get(1)
            if (ReStatementParser.isFiledToken(firstContentNode.getContent())) {
                Field field = new Field()
                field.setIdentity(ReStatementParser.extractFiled(firstContentNode.getContent()))
                field.setFieldType(ReStatementParser.extractFiledType(firstContentNode.getNext().getContent()))
                field.setLength(ReStatementParser.extractFiledLength(firstContentNode.getNext().getContent(), field.getFieldType()))
                field.setComment(ReStatementParser.extractFiledComment(statement))
                fields << field
            }
        }
        fields
    }

}
