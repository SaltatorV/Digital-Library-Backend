package com.digilib.item.server.service;

import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.port.input.ItemCommandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemCommandServiceImplTest {

    private ItemCommandService itemCommandService;

    @BeforeEach
    public void setup(){
        itemCommandService = new ItemCommandServiceImpl();
    }

    @Test
    public void shouldCreateNewItem() {
        //given
        var command = preapreCreateItemCommand();

        //when
        var result = itemCommandService.createItem(command);

        //then
        assertEquals("Item successfully created!", result.getMessage());
    }

    @Test
    public void shouldDeleteItem() {
        //given
        var ISBN = createISBN();

        //when
        var result = itemCommandService.deleteItem(ISBN);

        //then
        assertEquals("Item successfully deleted!", result.getMessage());
    }

    @Test
    public void shouldUpdateItem() {
        //given
        var ISBN = createISBN();

        //when
        var result = itemCommandService.updateItem(ISBN);

        //then
        assertEquals("Item successfully updated!", result.getMessage());
    }

    private CreateItemCommand preapreCreateItemCommand() {
        return new CreateItemCommand(createISBN());
    }

    public String createISBN() {
        return "0-061-96436-0";
    }
}
