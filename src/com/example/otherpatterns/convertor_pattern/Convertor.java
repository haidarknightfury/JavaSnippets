package com.example.otherpatterns.convertor_pattern;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Convertor<T, U> {

    private final Function<T, U> fromDto;
    private final Function<U, T> fromEntity;

    public Convertor(Function<T, U> fromDto, Function<U, T> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public final U convertFromDto(T dto) {
        return this.fromDto.apply(dto);
    }

    public final T convertFromEntity(U entity) {
        return this.fromEntity.apply(entity);
    }

    public List<U> createFromDtos(final Collection<T> dtos) {
        return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
    }

    public final List<T> createFromEntities(final Collection<U> ents) {
        return ents.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }
}
