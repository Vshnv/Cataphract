package com.github.vshnv.cataphract.parser;

import java.util.List;

public interface Lexer {
    List<Token> lexer(String input);
}
