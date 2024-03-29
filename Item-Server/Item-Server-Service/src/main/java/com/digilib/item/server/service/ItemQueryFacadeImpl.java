package com.digilib.item.server.service;

import com.digilib.item.server.domain.exception.ItemNotFoundException;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;
import com.digilib.item.server.service.port.input.ItemQueryFacade;
import com.digilib.item.server.service.port.output.ItemQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class ItemQueryFacadeImpl implements ItemQueryFacade {

    private final ItemQueryRepository itemQueryRepository;

    @Override
    public ItemResponse findItem(String isbn) {
        Optional<ItemSnapshot> snapshot = itemQueryRepository.findByIsbn(isbn);

        if(snapshot.isEmpty()) {
            throw ItemNotFoundException.createForIsbn(isbn);
        }

        return ItemResponse.create(snapshot.get().getIsbn());
    }

    @Override
    public List<ItemSummaryResponse> fetchItemsSummary() {
        return List.of(
                ItemSummaryResponse.create("Title-1", "Author-1", "exampleLink1"),
                ItemSummaryResponse.create("Title-2", "Author-2", "exampleLink2"),
                ItemSummaryResponse.create("Title-3", "Author-3", "exampleLink3")
        );
    }
}
