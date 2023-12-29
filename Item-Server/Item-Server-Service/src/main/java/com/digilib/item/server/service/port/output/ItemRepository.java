package com.digilib.item.server.service.port.output;

import java.util.Optional;

public interface ItemRepository {
    Optional<String> findByISBN(String ISBN);
}
