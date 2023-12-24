package com.digilib.item.server.service.port.input;

import com.digilib.item.server.service.dto.response.ItemResponse;

public interface ItemQueryService {

    ItemResponse findItem(String ISBN);
}
