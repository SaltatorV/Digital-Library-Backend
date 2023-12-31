package com.digilib.common.domain.vo;

import java.util.Objects;
import java.util.UUID;

public abstract class BaseId {
    private final UUID id;

    public BaseId(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId baseId = (BaseId) o;
        return Objects.equals(id, baseId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
