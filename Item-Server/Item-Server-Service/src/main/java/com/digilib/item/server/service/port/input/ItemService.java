package com.digilib.item.server.service.port.input;

import com.digilib.item.server.service.dto.response.ItemResponse;

public interface ItemService {

    ItemResponse findItem(String ISBN);
}
