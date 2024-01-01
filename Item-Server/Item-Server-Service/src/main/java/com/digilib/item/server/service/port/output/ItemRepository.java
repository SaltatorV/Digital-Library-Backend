package com.digilib.item.server.service.port.output;

import com.digilib.item.server.domain.vo.ItemSnapshot;

import java.util.Optional;

public interface ItemRepository {
    Optional<ItemSnapshot> findByISBN(String ISBN);
    void save(ItemSnapshot snapshot);
    boolean existsByISBN(String ISBN);

}
