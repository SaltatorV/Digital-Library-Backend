package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;
import com.digilib.item.server.service.port.input.ItemQueryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemQueryController {

    private final ItemQueryFacade itemQueryFacade;

    @GetMapping("{isbn}")
    ItemResponse findItem(@PathVariable String isbn) {
        return itemQueryFacade.findItem(isbn);
    }

    @GetMapping
    public List<ItemSummaryResponse> findItemsSummary() {
        return itemQueryFacade.fetchItemsSummary();
    }
}
