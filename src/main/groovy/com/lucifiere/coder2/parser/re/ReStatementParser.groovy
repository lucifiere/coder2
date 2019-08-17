package com.lucifiere.coder2.parser.re

import cn.hutool.core.util.StrUtil

final class ReStatementParser {

    static Statement createStatement(String line) {
        List<String> tokenStrList = line.tokenize(StrUtil.SPACE)
        Token root = new Token(TokenTypeEnum.ROOT, StrUtil.EMPTY)
        Token firstOne = createTokens(root, tokenStrList.iterator())
        root.next(firstOne)
        List<Token> tokens = extractTokenList(root)
        new Statement(tokens, tokenStrList)
    }

    private static Token createTokens(Token prev, Iterator<String> itr) {
        if (!itr.hasNext()) {
            return null
        }
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
        while (cur.getNext() != null) {
            tokens << cur
            cur = cur.getNext()
        }
        tokens
    }

}
