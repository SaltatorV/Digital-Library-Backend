package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;
import com.digilib.item.server.service.port.input.ItemQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemQueryController {

    private final ItemQueryService itemQueryService;

    public ItemQueryController(ItemQueryService itemQueryService) {
        this.itemQueryService = itemQueryService;
    }

    @GetMapping("{ISBN}")
    ItemResponse findItem(@PathVariable String ISBN) {
        return itemQueryService.findItem(ISBN);
    }

    @GetMapping
    public List<ItemSummaryResponse> findItemsSummary() {
        return itemQueryService.fetchItemsSummary();
    }
}
