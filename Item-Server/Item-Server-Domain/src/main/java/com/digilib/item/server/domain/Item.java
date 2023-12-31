package com.digilib.item.server.domain;

import com.digilib.item.server.domain.vo.ItemId;
import com.digilib.item.server.domain.vo.ItemSnapshot;

class Item {
    private ItemId id;

    public Item() {
        initialize();
    }

    public ItemSnapshot createSnapshot() {
        return new ItemSnapshot(id.getId());
    }

    private void initialize() {
        this.id = ItemId.generate();
    }


}
