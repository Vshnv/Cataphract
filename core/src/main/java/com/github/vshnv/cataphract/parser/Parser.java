package com.github.vshnv.cataphract.parser;

import com.github.vshnv.cataphract.nodes.Node;

import java.lang.reflect.Method;
import java.util.List;

public interface Parser {
    List<Node> parse(List<Token> tokenList, Method handler);
}
