package com.digilib.item.server.domain;

import com.digilib.item.server.domain.vo.ItemId;
import com.digilib.item.server.domain.vo.ItemSnapshot;

class Item {
    private final ItemId id;
    private final String isbn;

    private Item(ItemId id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

    public static Item initializeItem(ItemSnapshot snapshot) {
        return new Item(ItemId.generate(), snapshot.getIsbn());
    }

    public ItemSnapshot createSnapshot() {
        return new ItemSnapshot(id.getId(), isbn);
    }
}
