package com.digilib.item.server.domain;

import com.digilib.item.server.domain.vo.ItemSnapshot;

class ItemDomainFacadeImpl implements ItemDomainFacade{


    @Override
    public ItemSnapshot createItem(ItemSnapshot createFrom) {
        Item item = Item.initializeItem(createFrom);
        return item.createSnapshot();
    }
}
