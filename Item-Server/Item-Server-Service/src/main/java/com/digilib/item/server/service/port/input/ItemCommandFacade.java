package com.digilib.item.server.service.port.input;

import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;
import com.digilib.item.server.service.dto.response.MessageResponse;

public interface ItemCommandFacade {

    MessageResponse createItem(CreateItemCommand command);

    MessageResponse deleteItem(String isbn);

    MessageResponse updateItem(String isbn);

    MessageResponse createItemDetails(String isbn, CreateItemDetailsCommand command);
}
