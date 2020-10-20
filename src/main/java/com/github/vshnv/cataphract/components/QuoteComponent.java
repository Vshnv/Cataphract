package com.github.vshnv.cataphract.components;

import com.mojang.brigadier.builder.ArgumentBuilder;

import static com.mojang.brigadier.arguments.StringArgumentType.string;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;

public class QuoteComponent extends CommandComponent {
    public QuoteComponent(String name) {
        super(name);
    }

    @Override
    public ArgumentBuilder asBrigadierComponent() {
        return argument(getName(), string());
    }
}
