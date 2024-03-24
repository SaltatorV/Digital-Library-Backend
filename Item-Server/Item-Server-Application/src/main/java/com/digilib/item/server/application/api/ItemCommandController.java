package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;
import com.digilib.item.server.service.dto.command.UpdateItemCommand;
import com.digilib.item.server.service.dto.response.MessageResponse;
import com.digilib.item.server.service.port.input.ItemCommandFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemCommandController {
    private final ItemCommandFacade itemCommandFacade;

    @PostMapping
    public MessageResponse saveItem(@RequestBody CreateItemCommand command) {
        return itemCommandFacade.createItem(command);
    }

    @DeleteMapping("{isbn}")
    public MessageResponse deleteItem(@PathVariable String isbn) {
        return itemCommandFacade.deleteItem(isbn);
    }

    @PatchMapping("{isbn}")
    public MessageResponse updateItem(@PathVariable String isbn, @RequestBody UpdateItemCommand command) {
        return itemCommandFacade.updateItem(isbn, command);
    }

    @PostMapping("{isbn}/details")
    public MessageResponse createItemDetails(@PathVariable String isbn, @RequestBody CreateItemDetailsCommand command) {
        return itemCommandFacade.createItemDetails(isbn, command);
    }
}
