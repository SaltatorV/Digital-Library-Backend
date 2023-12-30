package com.digilib.item.server.service;

import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;
import com.digilib.item.server.service.exception.ItemNotFoundException;
import com.digilib.item.server.service.port.input.ItemQueryService;
import com.digilib.item.server.service.port.output.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ItemQueryServiceImpl implements ItemQueryService {

    private final ItemRepository itemRepository;

    public ItemQueryServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemResponse findItem(String ISBN) {
        Optional<String> ISBNFromDb = itemRepository.findByISBN(ISBN);

        if(ISBNFromDb.isEmpty()) {
            throw new ItemNotFoundException();
        }

        return ItemResponse.create(ISBNFromDb.get());
    }

    @Override
    public List<ItemSummaryResponse> fetchItemsSummary() {
        byte[] avatarBytes = Base64.getDecoder().decode("/9j/4AAQAAANAAAABAAEAA");


        return List.of(
                ItemSummaryResponse.create("Title-1", "Author-1", avatarBytes),
                ItemSummaryResponse.create("Title-2", "Author-2", avatarBytes),
                ItemSummaryResponse.create("Title-3", "Author-3", avatarBytes)
        );
    }
}
