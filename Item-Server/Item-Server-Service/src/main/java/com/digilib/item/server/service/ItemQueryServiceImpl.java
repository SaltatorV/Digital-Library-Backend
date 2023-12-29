package com.digilib.item.server.service;

import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;
import com.digilib.item.server.service.port.input.ItemQueryService;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class ItemQueryServiceImpl implements ItemQueryService {
    @Override
    public ItemResponse findItem(String ISBN) {
        return ItemResponse.create(ISBN);
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
