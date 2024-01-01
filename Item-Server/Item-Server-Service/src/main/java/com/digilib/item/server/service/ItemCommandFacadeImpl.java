package com.digilib.item.server.service;

import com.digilib.item.server.domain.ItemDomainFacade;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;
import com.digilib.item.server.service.dto.response.MessageResponse;
import com.digilib.item.server.service.port.input.ItemCommandFacade;
import org.springframework.stereotype.Service;

@Service
class ItemCommandFacadeImpl implements ItemCommandFacade {

    private final ItemDomainFacade itemDomainFacade;

    public ItemCommandFacadeImpl(ItemDomainFacade itemDomainFacade) {
        this.itemDomainFacade = itemDomainFacade;
    }

    @Override
    public MessageResponse createItem(CreateItemCommand command) {
        ItemSnapshot snapshot = new ItemSnapshot(command.getISBN());
        ItemSnapshot initializedSnapshot = itemDomainFacade.createItem(snapshot);
        return MessageResponse.create("Item successfully created!");
    }

    @Override
    public MessageResponse deleteItem(String isbn) {
        return MessageResponse.create("Item successfully deleted!");
    }

    @Override
    public MessageResponse updateItem(String isbn) {
        return MessageResponse.create("Item successfully updated!");
    }

    @Override
    public MessageResponse createItemDetails(String isbn, CreateItemDetailsCommand command) {
        return MessageResponse.create("Item details successfully bounded!");
    }
}
