package com.digilib.item.server.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ItemDomainFacade itemDomainFacade() {
        return new ItemDomainFacadeImpl();
    }
}
