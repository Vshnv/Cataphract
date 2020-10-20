package com.github.vshnv.cataphract.parser;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class CommandLexer implements Lexer {
    private final Matcher matcher = TokenType.getCombinedPattern().matcher("");
    public List<Token> lexer(String command) {
        matcher.reset(command);
        List<Token> tokenizedCommand = new ArrayList<>();
        matchingLoop:
        while (matcher.find()) {
            for (TokenType tok : TokenType.values()) {
                if (matcher.group(tok.name()) != null) {
                    tokenizedCommand.add(tok.evaluateToken(matcher.group(tok.name())));
                    continue matchingLoop;
                }
            }
        }
        return tokenizedCommand;
    }
}
