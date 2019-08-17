package com.lucifiere.coder2

import com.lucifiere.coder2.parser.re.ReStatementParser
import org.junit.Test

class ReStatementParserTests {

    @Test
    void testCreateStatement() {
        String line = "1 2 3 4"
        println ReStatementParser.createStatement(line)
    }

}
