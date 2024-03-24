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
                .withIsbn("978-0547928227")
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
        var isbn = "978-0547928227";

        returnMessageFromFacade("Item successfully deleted!", isbn);

        //when
        var response = deleteItem(isbn);

        //then
        assertResponseMessageIs(response, "Item successfully deleted!");
    }

    @Test
    public void shouldUpdateItem() {

        //given
        var isbn = "978-0547928227";
        var command = buildUpdateItemCommand()
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        returnMessageFromFacade("Item successfully updated!", isbn, command);

        //when
        var response = updateItem(isbn, command);

        //then
        assertResponseMessageIs(response, "Item successfully updated!");
    }

    @Test
    public void shouldCreateItemDetails() {
        //given
        var isbn = "978-0547928227";
        var command = buildCreateItemDetailsCommand()
                .withQuantity(1)
                .withDefaultImg()
                .withWidth(145)
                .withHeight(220)
                .withThickness(30)
                .create();

        returnMessageFromFacade("Item details successfully bounded!", isbn, command);


        //when
        var response = createItemDetails(isbn, command);

        //then
        assertResponseMessageIs(response, "Item details successfully bounded!");
    }

    private MessageResponse saveItem(CreateItemCommand command) {
        return itemCommandController.saveItem(command);
    }

    private MessageResponse deleteItem(String isbn) {
        return itemCommandController.deleteItem(isbn);
    }

    private MessageResponse updateItem(String isbn, UpdateItemCommand command){
        return itemCommandController.updateItem(isbn, command);
    }

    private MessageResponse createItemDetails(String isbn, CreateItemDetailsCommand command){
        return itemCommandController.createItemDetails(isbn, command);
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

    private void returnMessageFromFacade(String message, String isbn) {
        doReturn(createResponseWithMessage(message))
                .when(itemCommandFacade)
                .deleteItem(isbn);;
    }

    private void returnMessageFromFacade(String message, String isbn, UpdateItemCommand command) {
        doReturn(createResponseWithMessage(message))
                .when(itemCommandFacade)
                .updateItem(isbn, command);
    }

    private void returnMessageFromFacade(String message, String isbn, CreateItemDetailsCommand command) {
        doReturn(createResponseWithMessage(message))
                .when(itemCommandFacade)
                .createItemDetails(isbn, command);
    }

    private MessageResponse createResponseWithMessage(String message) {
        return MessageResponse.create(message);
    }

    private void assertResponseMessageIs(MessageResponse response, String expectedMessage) {
        assertEquals(expectedMessage, response.getMessage());
    }
}
