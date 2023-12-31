package com.digilib.item.server.domain.vo;

import com.digilib.common.domain.vo.BaseId;

import java.util.UUID;

public class ItemId extends BaseId {
    private ItemId(UUID id) {
        super(id);
    }
    public static ItemId generate() {
        return new ItemId(UUID.randomUUID());
    }
}
