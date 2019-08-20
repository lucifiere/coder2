package com.lucifiere.coder2.provider.parser.re

class Statement {

    final private List<Token> tokens

    final private List<String> tokenStr

    final private String line

    Statement(String line, List<Token> tokens, List<String> tokenStr) {
        this.tokens = tokens
        this.line = line
        this.tokenStr = tokenStr
    }

    List<Token> getTokens() {
        return tokens
    }

    List<String> getTokenStr() {
        return tokenStr
    }

    String getLine() {
        return line
    }

    @Override
    String toString() {
        return "Statement{" +
                "tokens=" + tokens +
                ", tokenStr=" + tokenStr +
                '}'
    }

}
