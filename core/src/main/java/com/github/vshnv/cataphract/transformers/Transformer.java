package com.github.vshnv.cataphract.transformers;

public interface Transformer {
    boolean canTransform(String input);
    Object transform(String input);
}
