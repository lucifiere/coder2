package com.lucifiere.coder2.parser.re

import cn.hutool.core.util.StrUtil

final class ReParserUtils {

    static TokenTypeEnum analysisTokenType(String literal) {
        null
    }

    static void checkTokenAvailable(String literal) {
        def available = StrUtil.isNotBlank(literal)
        if (!available) {
            throw new RuntimeException()
        }
    }

}
