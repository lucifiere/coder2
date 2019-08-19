package com.lucifiere.coder2.provider.parser.re

class RePattern {

    final static def COMMENT_PAT = ~/(?<=').*(?=')/

    final static def FIELD_TYPE_PAT = ~/.*(?=\()/

    final static def FIELD_lEN_PAT = ~/(?<=\().*(?=\))/

}
