package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;
import com.digilib.item.server.service.port.input.ItemQueryFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemQueryController {

    private final ItemQueryFacade itemQueryFacade;

    public ItemQueryController(ItemQueryFacade itemQueryFacade) {
        this.itemQueryFacade = itemQueryFacade;
    }

    @GetMapping("{ISBN}")
    ItemResponse findItem(@PathVariable String ISBN) {
        return itemQueryFacade.findItem(ISBN);
    }

    @GetMapping
    public List<ItemSummaryResponse> findItemsSummary() {
        return itemQueryFacade.fetchItemsSummary();
    }
}
