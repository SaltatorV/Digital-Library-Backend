package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.response.ItemResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {


    @GetMapping("{ISBN}")
    ItemResponse findItem(@PathVariable String ISBN) {
        return ItemResponse.create(ISBN);
    }
}
