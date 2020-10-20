package com.github.vshnv.cataphract.components;

import com.mojang.brigadier.builder.ArgumentBuilder;

import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;

public class IntComponent extends CommandComponent {
    private final int min;
    private final int max;
    public IntComponent(String name, int min, int max) {
        super(name);
        this.min = min;
        this.max = max;
    }

    public IntComponent(String name) {
        this(name, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    @Override
    public ArgumentBuilder asBrigadierComponent() {
        return argument(getName(),integer(min, max));
    }
}
