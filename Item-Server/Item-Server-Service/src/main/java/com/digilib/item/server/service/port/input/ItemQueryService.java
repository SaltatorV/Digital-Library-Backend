package com.digilib.item.server.service.port.input;

import java.util.List;

import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;

public interface ItemQueryService {

    ItemResponse findItem(String ISBN);

    List<ItemSummaryResponse> fetchItemsSummary();
}
