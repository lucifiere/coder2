package com.lucifiere.coder2.parser.re

class Token {

    private TokenTypeEnum type

    private String content

    private Token next

    private Token prev

    Token(TokenTypeEnum type, String content) {
        this.type = type
        this.content = content
    }

    void next(Token next) {
        this.next = next
    }

    void prev(Token prev) {
        this.prev = prev
    }

    TokenTypeEnum getType() {
        return type
    }

    void setType(TokenTypeEnum type) {
        this.type = type
    }

    String getContent() {
        return content
    }

    void setContent(String content) {
        this.content = content
    }

    Token getNext() {
        return next
    }

    void setNext(Token next) {
        this.next = next
    }

    Token getPrev() {
        return prev
    }

    void setPrev(Token prev) {
        this.prev = prev
    }

    @Override
    String toString() {
        return "Token{" +
                "type=" + type +
                ", content='" + content + '\'' +
                '}'
    }

}
