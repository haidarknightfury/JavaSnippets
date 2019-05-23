package com.example.otherpatterns.abstract_document_pattern;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public interface Document {

    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);

    Object get(String key);

    Void put(String key, Object value);

}
