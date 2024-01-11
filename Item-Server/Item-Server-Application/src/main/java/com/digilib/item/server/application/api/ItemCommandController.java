package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;
import com.digilib.item.server.service.dto.command.UpdateItemCommand;
import com.digilib.item.server.service.dto.response.MessageResponse;
import com.digilib.item.server.service.port.input.ItemCommandFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemCommandController {
    private final ItemCommandFacade itemCommandFacade;

    public ItemCommandController(ItemCommandFacade itemCommandFacade) {
        this.itemCommandFacade = itemCommandFacade;
    }

    @PostMapping
    public MessageResponse saveItem(@RequestBody CreateItemCommand command) {
        return itemCommandFacade.createItem(command);
    }

    @DeleteMapping("{ISBN}")
    public MessageResponse deleteItem(@PathVariable String ISBN) {
        return itemCommandFacade.deleteItem(ISBN);
    }

    @PatchMapping("{ISBN}")
    public MessageResponse updateItem(@PathVariable String ISBN, @RequestBody UpdateItemCommand command) {
        return itemCommandFacade.updateItem(ISBN, command);
    }

    @PostMapping("{ISBN}/details")
    public MessageResponse createItemDetails(@PathVariable String ISBN, @RequestBody CreateItemDetailsCommand command) {
        return itemCommandFacade.createItemDetails(ISBN, command);
    }
}
