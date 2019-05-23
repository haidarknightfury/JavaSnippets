package com.example.otherpatterns.abstract_document_pattern;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class AbstractDocument implements Document {

    private Map<String, Object> properties;

    public AbstractDocument(Map<String, Object> properties) {
        Objects.requireNonNull(properties, "properties map is required");
        this.properties = properties;
    }

    @Override
    public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor) {
        Optional<List<Map<String, Object>>> any = Stream.of(this.get(key)).filter(el -> el != null).map(el -> (List<Map<String, Object>>) el).findAny();
        return any.isPresent() ? any.get().stream().map(constructor) : Stream.empty();
    }

    @Override
    public Object get(String key) {
        return this.properties.get(key);
    }

    @Override
    public Void put(String key, Object value) {
        this.properties.put(key, value);
        return null;
    }

}
