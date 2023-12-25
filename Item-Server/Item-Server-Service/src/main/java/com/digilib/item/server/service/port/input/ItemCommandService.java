package com.digilib.item.server.service.port.input;

import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.response.MessageResponse;

public interface ItemCommandService {

    MessageResponse createItem(CreateItemCommand command);
}
