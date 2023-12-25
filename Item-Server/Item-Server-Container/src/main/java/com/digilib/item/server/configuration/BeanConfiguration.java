package com.digilib.item.server.configuration;

import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.response.ItemResponse;
import com.digilib.item.server.service.dto.response.ItemSummaryResponse;
import com.digilib.item.server.service.dto.response.MessageResponse;
import com.digilib.item.server.service.port.input.ItemCommandService;
import com.digilib.item.server.service.port.input.ItemQueryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean
    public ItemCommandService itemCommandService() {
        return new ItemCommandService() {
            @Override
            public MessageResponse createItem(CreateItemCommand command) {
                return MessageResponse.create("Item successfully created!");
            }

            @Override
            public MessageResponse deleteItem(String isbn) {
                return MessageResponse.create("Item successfully deleted!");
            }

            @Override
            public MessageResponse updateItem(String isbn) {
                return MessageResponse.create("Item successfully updated!");
            }
        };
    }
}
