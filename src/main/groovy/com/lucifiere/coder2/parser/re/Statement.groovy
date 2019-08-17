package com.lucifiere.coder2.parser.re

class Statement {

    final private List<Token> tokens

    final private List<String> line

    Statement(List<Token> tokens, List<String> line) {
        this.tokens = tokens
        this.line = line
    }

    @Override
    String toString() {
        return "Statement{" +
                "tokens=" + tokens +
                ", line=" + line +
                '}'
    }

}
