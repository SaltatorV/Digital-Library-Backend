package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;
import com.digilib.item.server.service.dto.command.UpdateItemCommand;
import com.digilib.item.server.service.dto.response.MessageResponse;
import com.digilib.item.server.service.port.input.ItemCommandFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ItemCommandControllerTest {


    @Mock
    ItemCommandFacade itemCommandFacade;
    @InjectMocks
    ItemCommandController itemCommandController;

    @Test
    public void shouldSaveNewItem() {

        //given
        var command = prepareAddTheHobbitCommand();
        var expected = createResponseWithMessage("Item successfully created!");
        doReturn(expected)
                .when(itemCommandFacade)
                .createItem(command);

        //when
        var response = itemCommandController.saveItem(command);

        //then
        assertEquals(expected, response);
    }

    @Test
    public void shouldDeleteItem() {
        //given
        var ISBN = createISBN();
        var expected = createResponseWithMessage("Item successfully deleted!");
        doReturn(expected)
                .when(itemCommandFacade)
                .deleteItem(ISBN);

        //when
        var response = itemCommandController.deleteItem(ISBN);

        //then
        assertEquals(expected, response);
    }

    @Test
    public void shouldUpdateItem() {

        //given
        var ISBN = createISBN();
        var command = prepareUpdateTheHobbitCommand();
        var expected = createResponseWithMessage("Item successfully updated!");
        doReturn(expected)
                .when(itemCommandFacade)
                .updateItem(ISBN, command);
        //when
        var response = itemCommandController.updateItem(ISBN, command);

        //then
        assertEquals(expected, response);
    }

    @Test
    public void shouldCreateItemDetails() {
        //given
        var ISBN = createISBN();
        var command = prepareItemDetails();
        var expected = createResponseWithMessage("Item details successfully bounded!");

        doReturn(expected)
                .when(itemCommandFacade)
                .createItemDetails(ISBN, command);

        //when
        var response = itemCommandController.createItemDetails(ISBN, command);

        //then
        assertEquals(expected, response);
    }

    public String createISBN() {
        return "0-061-96436-0";
    }

    private CreateItemCommand prepareAddTheHobbitCommand() {
        return new CreateItemCommand("978-0547928227", "Fantasy" ,"The Hobbit: Or There and Back Again",
                "J.R.R. Tolkien", "William Morrow & Company", Date.valueOf("2012-10-18"));
    }

    private UpdateItemCommand prepareUpdateTheHobbitCommand() {
        return new UpdateItemCommand("The Hobbit: Or There and Back Again",
                "J.R.R. Tolkien", "William Morrow & Company", Date.valueOf("2012-10-18"));
    }

    private CreateItemDetailsCommand prepareItemDetails() {
        int quantity = 1;
        byte[] img = {0,1,0,1,1,1,1};
        double widthInMM = 133.4;
        double heightInMM = 215.9;
        double thicknessInMM = 25.4;

        return new CreateItemDetailsCommand(quantity, img, widthInMM, heightInMM, thicknessInMM);
    }

    private MessageResponse createResponseWithMessage(String message) {
        return MessageResponse.create(message);
    }
}
