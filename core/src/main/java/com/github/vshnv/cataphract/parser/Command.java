package com.github.vshnv.cataphract.parser;

import com.github.vshnv.cataphract.nodes.Node;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Command {
    private final boolean requestsExecutor;
    private final List<Node> commandNodes;
    private final Method handler;

    public Command(boolean requestsExecutor, List<Node> commandNodes, Method handler) {
        this.requestsExecutor = requestsExecutor;
        this.commandNodes = commandNodes;
        this.handler = handler;
    }

    public boolean isExecutorRequested() {
        return requestsExecutor;
    }

    public List<Node> getCommandNodes() {
        return commandNodes;
    }

    public Method getHandler() {
        return handler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return commandNodes.equals(command.commandNodes) &&
                handler.equals(command.handler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandNodes, handler);
    }
}
