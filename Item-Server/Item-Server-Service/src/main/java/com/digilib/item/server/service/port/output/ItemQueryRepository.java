package com.digilib.item.server.service.port.output;

import com.digilib.item.server.domain.vo.ItemSnapshot;

import java.util.Optional;

public interface ItemQueryRepository {

    Optional<ItemSnapshot> findByIsbn(String isbn);

}
