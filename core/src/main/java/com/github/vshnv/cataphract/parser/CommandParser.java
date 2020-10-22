package com.github.vshnv.cataphract.parser;

import com.github.vshnv.cataphract.executor.Executor;
import com.github.vshnv.cataphract.nodes.Node;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;

public class CommandParser implements Parser {
    @Override
    public Command parse(List<Token> tokenList, Method handler) {
        Parameter[] params = handler.getParameters();
        boolean requestingExecutor =
                params.length > 0 && params[0].getType().isAssignableFrom(Executor.class);
        Map<String, Class<?>> parameterMap = new HashMap<>();
        int index = requestingExecutor ? 1 : 0;
        for (int i = index; i < params.length; i++) {
            parameterMap.put(params[i].getName(), params[i].getType());
        }

        List<Node> resNode = tokenList.stream().map(it -> {
            Class<?> clazz = null;
            if (it.getType() == TokenType.ARGUMENT) {
                clazz = Objects.requireNonNull(parameterMap.get(it.getContent()));
            }
            return Node.from(it, clazz);
        }).collect(Collectors.toList());

        return new Command(requestingExecutor, resNode, handler);
    }
}
