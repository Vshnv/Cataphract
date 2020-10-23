package com.github.vshnv.cataphract.nodes;

import com.github.vshnv.cataphract.transformer.Transformer;
import com.github.vshnv.cataphract.transformer.TransformerRegistry;

import java.util.Objects;

public class ArgumentNode extends Node {
    private final Class typeClazz;
    private final String name;
    private Transformer transformer;
    public ArgumentNode(Class typeClazz, String name) {
        this.typeClazz = typeClazz;
        this.name = name;
    }

    public Class getTypeClazz() {
        return typeClazz;
    }

    public Transformer getTransformer() {
        if (transformer == null) {
            this.transformer = TransformerRegistry.INSTANCE.getTransformer(typeClazz);
        }
        return transformer;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean matches(String input) {
        return getTransformer().transform(input) != null;
    }

    public Object parse(String input) {
        return getTransformer().transform(input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArgumentNode that = (ArgumentNode) o;
        return typeClazz.equals(that.typeClazz) &&
                name.equals(that.name) &&
                Objects.equals(transformer, that.transformer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeClazz, name, transformer);
    }
}
