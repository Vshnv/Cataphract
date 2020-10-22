package com.github.vshnv.cataphract;

import static org.junit.Assert.*;

import com.github.vshnv.cataphract.nodes.Node;
import com.github.vshnv.cataphract.parser.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CommandParserTest {
    private final Lexer lexer = new CommandLexer();
    private final Parser parser = new CommandParser();
    private final DummyCommand dummyCommand = new DummyCommand();
    @Test
    public void testBasicParsing() {
        List<Token> result = lexer.lexer("cataphract <enable/en> [value]");
        Command command = parser.parse(result, dummyCommand.getClass().getMethods()[0]);
        assertEquals(
                command,
                new Command(false,
                        Arrays.asList(
                                Node.from(Token.of(TokenType.KEYWORD, "cataphract"), null),
                                Node.from(Token.of(TokenType.ALIAS, "enable/en"),null),
                                Node.from(Token.of(TokenType.ARGUMENT, "value"), dummyCommand.getClass().getMethods()[0].getParameters()[0].getType())
                        ),
                        dummyCommand.getClass().getMethods()[0]
                )
        );
    }

}
