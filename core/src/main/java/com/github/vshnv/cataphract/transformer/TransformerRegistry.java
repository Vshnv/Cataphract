package com.github.vshnv.cataphract.transformer;

import java.util.HashMap;
import java.util.Map;

public enum TransformerRegistry {
    INSTANCE;
    private final Map<Class<?>, Transformer> transformerMap = new HashMap<>();

    TransformerRegistry() {
        registerTransformer(boolean.class, (arg) -> Boolean.valueOf(arg));

    }


    public boolean registerTransformer(Class<?> clazz, Transformer transformer) {
        return transformerMap.putIfAbsent(clazz, transformer) == null;
    }

    public Transformer getTransformer(Class<?> clazz) {
        return transformerMap.get(clazz);
    }
}
