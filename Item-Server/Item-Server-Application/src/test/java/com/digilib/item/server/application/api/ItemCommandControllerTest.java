package com.digilib.item.server.application.api;

import com.digilib.item.server.application.builder.CreateItemCommandBuilder;
import com.digilib.item.server.application.builder.CreateItemDetailsCommandBuilder;
import com.digilib.item.server.application.builder.UpdateItemCommandBuilder;
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
        var command = buildCreateItemCommand()
                .withISBN("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        returnMessageFromFacade("Item successfully created!", command);


        //when
        var response = saveItem(command);

        //then
        assertResponseMessageIs(response, "Item successfully created!");
    }

    @Test
    public void shouldDeleteItem() {
        //given
        var ISBN = "978-0547928227";

        returnMessageFromFacade("Item successfully deleted!", ISBN);

        //when
        var response = deleteItem(ISBN);

        //then
        assertResponseMessageIs(response, "Item successfully deleted!");
    }

    @Test
    public void shouldUpdateItem() {

        //given
        var ISBN = "978-0547928227";
        var command = buildUpdateItemCommand()
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        returnMessageFromFacade("Item successfully updated!", ISBN, command);

        //when
        var response = updateItem(ISBN, command);

        //then
        assertResponseMessageIs(response, "Item successfully updated!");
    }

    @Test
    public void shouldCreateItemDetails() {
        //given
        var ISBN = "978-0547928227";
        var command = buildCreateItemDetailsCommand()
                .withQuantity(1)
                .withDefaultImg()
                .withWidth(145)
                .withHeight(220)
                .withThickness(30)
                .create();

        returnMessageFromFacade("Item details successfully bounded!", ISBN, command);


        //when
        var response = createItemDetails(ISBN, command);

        //then
        assertResponseMessageIs(response, "Item details successfully bounded!");
    }

    private MessageResponse saveItem(CreateItemCommand command) {
        return itemCommandController.saveItem(command);
    }

    private MessageResponse deleteItem(String ISBN) {
        return itemCommandController.deleteItem(ISBN);
    }

    private MessageResponse updateItem(String ISBN, UpdateItemCommand command){
        return itemCommandController.updateItem(ISBN, command);
    }

    private MessageResponse createItemDetails(String ISBN, CreateItemDetailsCommand command){
        return itemCommandController.createItemDetails(ISBN, command);
    }

    private CreateItemCommandBuilder buildCreateItemCommand(){
        return CreateItemCommandBuilder.build();
    }

    private UpdateItemCommandBuilder buildUpdateItemCommand(){
        return UpdateItemCommandBuilder.build();
    }

    private CreateItemDetailsCommandBuilder buildCreateItemDetailsCommand(){
        return CreateItemDetailsCommandBuilder.build();
    }

    private void returnMessageFromFacade(String message, CreateItemCommand command) {
        doReturn(createResponseWithMessage(message))
                .when(itemCommandFacade)
                .createItem(command);
    }

    private void returnMessageFromFacade(String message, String ISBN) {
        doReturn(createResponseWithMessage(message))
                .when(itemCommandFacade)
                .deleteItem(ISBN);;
    }

    private void returnMessageFromFacade(String message, String ISBN, UpdateItemCommand command) {
        doReturn(createResponseWithMessage(message))
                .when(itemCommandFacade)
                .updateItem(ISBN, command);
    }

    private void returnMessageFromFacade(String message, String ISBN, CreateItemDetailsCommand command) {
        doReturn(createResponseWithMessage(message))
                .when(itemCommandFacade)
                .createItemDetails(ISBN, command);
    }

    private MessageResponse createResponseWithMessage(String message) {
        return MessageResponse.create(message);
    }

    private void assertResponseMessageIs(MessageResponse response, String expectedMessage) {
        assertEquals(expectedMessage, response.getMessage());
    }
}
