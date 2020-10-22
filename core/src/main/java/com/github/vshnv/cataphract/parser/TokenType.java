package com.github.vshnv.cataphract.parser;

import java.util.regex.Pattern;

public enum TokenType {
    ARGUMENT("\\[.+?]") {
        @Override
        public Token evaluateToken(String match) {
            return Token.of(this, match.substring(1, match.length() - 1));
        }
    },
    ALIAS("<.+?>") {
        @Override
        public Token evaluateToken(String match) {
            return Token.of(this, match.substring(1, match.length() - 1));
        }
    },
    KEYWORD("[\\S]+");

    private static Pattern cachedPattern;
    private String regex;

    TokenType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public static Pattern getCombinedPattern() {
        if (cachedPattern == null) {
            StringBuffer regexBuffer = new StringBuffer();
            for (TokenType value: values()) {
                regexBuffer
                        .append('|')
                        .append('(')
                        .append('?')
                        .append('<')
                        .append(value.toString())
                        .append('>')
                        .append(value.regex)
                        .append(')');
            }
            cachedPattern = Pattern.compile(regexBuffer.substring(1));
        }
        return cachedPattern;
    }

    public Token evaluateToken(String match) {
        return Token.of(this, match);
    }

}
