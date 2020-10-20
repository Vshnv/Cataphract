package com.github.vshnv.cataphract.nodes;

import java.util.Objects;

public class KeywordNode extends Node {
    private final String keyword;

    public KeywordNode(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean matches(String input) {
        return keyword.equalsIgnoreCase(input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeywordNode that = (KeywordNode) o;
        return keyword.equals(that.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyword);
    }
}
