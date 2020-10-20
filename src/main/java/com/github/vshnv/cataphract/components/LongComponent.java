package com.github.vshnv.cataphract.components;

import com.mojang.brigadier.builder.ArgumentBuilder;

import static com.mojang.brigadier.arguments.LongArgumentType.longArg;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;

public class LongComponent extends CommandComponent {
    private final long min;
    private final long max;
    public LongComponent(String name, long min, long max) {
        super(name);
        this.min = min;
        this.max = max;
    }
    public LongComponent(String name) {
        this(name, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    @Override
    public ArgumentBuilder asBrigadierComponent() {
        return argument(getName(), longArg(min, max));
    }
}
