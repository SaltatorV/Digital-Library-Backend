package com.digilib.common.domain.vo;

import java.util.Objects;

public class BaseId<T> {
    private final T value;

    protected BaseId(T value) {
        this.value = value;
    }

    public String getValue() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId<?> baseId = (BaseId<?>) o;
        return value.equals(baseId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}