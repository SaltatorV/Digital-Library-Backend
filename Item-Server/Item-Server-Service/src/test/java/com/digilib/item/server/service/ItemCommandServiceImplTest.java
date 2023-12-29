package com.digilib.item.server.service;

import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;
import com.digilib.item.server.service.port.input.ItemCommandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

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
        var command = prepareAddTheHobbitCommand();

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

    @Test
    public void shouldCreateItemDetails() {
        //given
        var ISBN = createISBN();
        var command = prepareItemDetails();

        //when
        var result = itemCommandService.createItemDetails(ISBN, command);

        //then
        assertEquals("Item details successfully bounded!", result.getMessage());
    }

    private CreateItemCommand prepareAddTheHobbitCommand() {
        return new CreateItemCommand("978-0547928227", "The Hobbit: Or There and Back Again",
                "J.R.R. Tolkien", "William Morrow & Company", Date.valueOf("2012-10-18"));
    }

    public String createISBN() {
        return "0-061-96436-0";
    }

    private CreateItemDetailsCommand prepareItemDetails() {
        int quantity = 1;
        byte[] img = {0,1,0,1,1,1,1};
        double widthInMM = 133.4;
        double heightInMM = 215.9;
        double thicknessInMM = 25.4;

        return new CreateItemDetailsCommand(quantity, img, widthInMM, heightInMM, thicknessInMM);
    }
}
