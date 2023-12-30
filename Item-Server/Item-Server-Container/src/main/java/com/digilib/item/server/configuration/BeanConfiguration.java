package com.digilib.item.server.configuration;

import com.digilib.item.server.service.port.output.ItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class BeanConfiguration {

    @Bean
    ItemRepository itemRepository() {
        return new ItemRepository() {
            List<String> ISBNs = List.of("1111", "2222", "3333", "4444");
            @Override
            public Optional<String> findByISBN(String ISBN) {
                return ISBNs
                        .stream()
                        .filter(x->x.equals(ISBN))
                        .findFirst();
            }
        };
    }
}
