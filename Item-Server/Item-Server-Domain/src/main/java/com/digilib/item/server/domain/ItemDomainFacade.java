package com.digilib.item.server.domain;

import com.digilib.item.server.domain.vo.ItemSnapshot;

public interface ItemDomainFacade {
    ItemSnapshot createItem(ItemSnapshot createFrom);
}
