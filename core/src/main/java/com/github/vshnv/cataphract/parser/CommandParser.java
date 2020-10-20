package com.github.vshnv.cataphract.parser;

import com.github.vshnv.cataphract.Executor;
import com.github.vshnv.cataphract.nodes.Node;

import java.lang.reflect.Method;
import java.util.List;

public class CommandParser implements Parser {
    @Override
    public List<Node> parse(List<Token> tokenList, Method handler) {
        Class<?>[] params = handler.getParameterTypes();
        boolean requestingExecutor =
                params.length > 0 &&
                params[0].isAssignableFrom(Executor.class);

        return null;
    }
}
