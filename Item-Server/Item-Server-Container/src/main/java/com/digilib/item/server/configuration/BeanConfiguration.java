package com.digilib.item.server.configuration;

import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;
import com.digilib.item.server.service.port.input.ItemQueryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean
    public ItemQueryService itemService() {
        return new ItemQueryService() {
            @Override
            public ItemResponse findItem(String ISBN) {
                return ItemResponse.create(ISBN);
            }

            @Override
            public List<ItemSummaryResponse> fetchItemsSummary() {
                return List.of(ItemSummaryResponse.create("Title-1"));
            }
        };
    }
}
