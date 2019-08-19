package com.lucifiere.coder2.provider.parser.re

import cn.hutool.core.util.StrUtil
import com.lucifiere.coder2.constants.FieldType
import com.lucifiere.coder2.constants.MySqlKeywords
import org.apache.commons.lang3.StringUtils
import org.springframework.util.CollectionUtils

final class ReStatementParser {

    static Statement createStatement(String line) {
        if (StrUtil.isBlank(line)) return null
        List<String> tokenStrList = line.tokenize(StrUtil.SPACE)
        Token root = new Token(TokenTypeEnum.ROOT, StrUtil.EMPTY)
        Token firstOne = createTokens(root, tokenStrList.iterator())
        root.next(firstOne)
        List<Token> tokens = extractTokenList(root)
        new Statement(line, tokens, tokenStrList)
    }

    private static Token createTokens(Token prev, Iterator<String> itr) {
        if (!itr.hasNext()) return null
        String cur = itr.next()
        ReParserUtils.checkTokenAvailable(cur)
        Token curToken = new Token(ReParserUtils.analysisTokenType(cur), cur)
        Token nextToken = createTokens(curToken, itr)
        curToken.prev(prev)
        curToken.next(nextToken)
        curToken
    }

    private static List<Token> extractTokenList(Token root) {
        List<Token> tokens = []
        Token cur = root
        while (cur != null) {
            tokens << cur
            cur = cur.getNext()
        }
        tokens
    }

    static String extractFiled(String value) {
        isFiledToken(value) ? value.substring(1, value.length() - 1) : ""
    }

    static String extractComment(String text) {
        text.find(RePattern.COMMENT_PAT) ?: ""
    }

    static boolean isFiledToken(String value) {
        StringUtils.isNotEmpty(value) && value.startsWith(MySqlKeywords.FILED_IDENTITY) && value.endsWith(MySqlKeywords.FILED_IDENTITY)
    }

    static FieldType extractFiledType(String text) {
        String type = text.find(RePattern.FIELD_TYPE_PAT) ?: text
        FieldType.findByLiteral(type)
    }

    static Integer extractFiledLength(String text, FieldType fieldType) {
        String length = text.find(RePattern.FIELD_lEN_PAT)
        def decimalType = [FieldType.NUM_DOUBLE, FieldType.NUM_FLOAT, FieldType.NUM_DECIMAL]
        if (StringUtils.isEmpty(length)) {
            return null
        }
        if (decimalType.contains(fieldType)) {
            return length.split(",")[0] as Integer
        }
        Integer.valueOf(length)
    }

    static String extractFiledComment(Statement statement) {
        if (!CollectionUtils.isEmpty(statement.getTokenStr())) {
            int keywordIndex = statement.getTokenStr().findLastIndexOf {
                StrUtil.equals(it, MySqlKeywords.COMMENT, true)
            } + 1
            return extractComment(statement.getTokenStr().get(keywordIndex))
        }
        null
    }

}
