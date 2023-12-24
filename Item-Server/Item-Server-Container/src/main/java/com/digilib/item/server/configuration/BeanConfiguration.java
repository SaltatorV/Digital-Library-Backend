package com.digilib.item.server.configuration;

import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.port.input.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ItemService itemService() {
        return new ItemService() {
            @Override
            public ItemResponse findItem(String ISBN) {
                return ItemResponse.create(ISBN);
            }
        };
    }
}
