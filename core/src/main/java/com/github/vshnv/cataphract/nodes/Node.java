package com.github.vshnv.cataphract.nodes;

import com.github.vshnv.cataphract.parser.Token;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public abstract class Node {
    public abstract boolean matches(String input);


    public static Node from(Token token, Class<?> extraData) {
        switch (token.getType()) {
            case ALIAS:
                return new AliasNode(Arrays.asList(token.getContent().split("/")));
            case KEYWORD:
                return new KeywordNode(token.getContent());
            case ARGUMENT:
                return new ArgumentNode(Objects.requireNonNull(extraData), token.getContent());
            default:
                throw new IllegalArgumentException("Invalid Token Type");
        }
    }
}
