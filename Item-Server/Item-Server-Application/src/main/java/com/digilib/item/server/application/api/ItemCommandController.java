package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.response.MessageResponse;
import com.digilib.item.server.service.port.input.ItemCommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemCommandController {

    private final ItemCommandService itemCommandService;

    public ItemCommandController(ItemCommandService itemCommandService) {
        this.itemCommandService = itemCommandService;
    }

    @PostMapping
    public MessageResponse saveItem(CreateItemCommand command) {
        return itemCommandService.createItem(command);
    }

    public MessageResponse deleteItem(String isbn) {
        return itemCommandService.deleteItem(isbn);
    }
}
