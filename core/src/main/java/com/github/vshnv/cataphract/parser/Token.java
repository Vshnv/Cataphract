package com.github.vshnv.cataphract.parser;

import java.util.Objects;

public class Token {
    private final TokenType type;
    private final String content;

    private Token(TokenType type, String content) {
        this.type = type;
        this.content = content;
    }

    public static Token of(TokenType type, String content) {
        return new Token(type, content);
    }
    public static Token of(TokenType type) {
        return new Token(type, "");
    }

    public TokenType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return type == token.type &&
                content.equals(token.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, content);
    }
}
