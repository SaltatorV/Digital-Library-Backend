package com.digilib.item.server.application.api;

import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.response.MessageResponse;
import com.digilib.item.server.service.port.input.ItemCommandService;
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
    ItemCommandService itemCommandService;
    @InjectMocks
    ItemCommandController itemCommandController;

    @Test
    public void shouldSaveNewItem() {

        //given
        var command = createItemCommand();
        var expected = createResponseWithMessage("Item successfully created!");
        doReturn(expected)
                .when(itemCommandService)
                .createItem(command);

        //when
        var response = itemCommandController.saveItem(command);

        //then
        assertEquals(expected, response);
    }

    private CreateItemCommand createItemCommand() {
        return new CreateItemCommand("978-83-644-7691-4");
    }

    private MessageResponse createResponseWithMessage(String message) {
        return MessageResponse.create(message);
    }
}
