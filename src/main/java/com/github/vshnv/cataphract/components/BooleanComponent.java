package com.github.vshnv.cataphract.components;

import com.mojang.brigadier.builder.ArgumentBuilder;

import static com.mojang.brigadier.arguments.BoolArgumentType.bool;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;

public class BooleanComponent extends CommandComponent {
    public BooleanComponent(String name) {
        super(name);
    }

    @Override
    public ArgumentBuilder asBrigadierComponent() {
        return argument(getName(), bool());
    }
}
