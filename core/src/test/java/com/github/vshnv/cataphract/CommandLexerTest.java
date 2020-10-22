package com.github.vshnv.cataphract;

import static org.junit.Assert.*;

import com.github.vshnv.cataphract.parser.CommandLexer;
import com.github.vshnv.cataphract.parser.Lexer;
import com.github.vshnv.cataphract.parser.Token;
import com.github.vshnv.cataphract.parser.TokenType;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;

public class CommandLexerTest {
    private final Lexer lexer = new CommandLexer();


    @Test
    public void testBasicLexing() {
        List<Token> result = lexer.lexer("cataphract <enable/en> [value]");
        assertEquals(result, Arrays.asList(
                Token.of(TokenType.KEYWORD, "cataphract"),
                Token.of(TokenType.ALIAS, "enable/en"),
                Token.of(TokenType.ARGUMENT, "value")
        ));
    }
}
