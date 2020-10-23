package com.github.vshnv.cataphract.handler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class CommandHandler {
    private final String command;

    protected CommandHandler() {
        this(null);
    }

    protected CommandHandler(String command) {
        this.command = command;
    }

    public final Method[] getCommandMethods() {
        return (Method[]) Arrays.stream(getClass().getMethods()).filter(it -> it.isAnnotationPresent(Syntax.class)).toArray();
    }

    /* Permissible annotations */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    protected @interface Syntax {
        String value();
    }
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    protected @interface Permission {
        String value();
    }
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    protected @interface MessageHandlerId {
        int value();
    }
}
