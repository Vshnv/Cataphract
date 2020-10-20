package com.github.vshnv.cataphract.components;

import com.mojang.brigadier.builder.ArgumentBuilder;

import static com.mojang.brigadier.arguments.FloatArgumentType.floatArg;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;

public class FloatComponent extends CommandComponent {

    private final float min;
    private final float max;

    public FloatComponent(String name, float min, float max) {
        super(name);
        this.min = min;
        this.max = max;
    }
    public FloatComponent(String name) {
        this(name, Float.MIN_VALUE, Float.MAX_VALUE);
    }

    @Override
    public ArgumentBuilder asBrigadierComponent() {
        return argument(getName(), floatArg(min, max));
    }
}
