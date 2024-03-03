package com.digilib.item.server.service.port.output;

import com.digilib.item.server.domain.vo.ItemSnapshot;

import java.util.Optional;

public interface ItemCommandRepository {
    void save(ItemSnapshot snapshot);
    boolean existsByISBN(String ISBN);

    void delete(String isbn);

    void update(ItemSnapshot snapshot);
}
