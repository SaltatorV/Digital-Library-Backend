package com.digilib.item.server.service;

import com.digilib.item.server.domain.ItemDomainFacade;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ItemCommandFacadeImplTest {

    @Mock
    private ItemDomainFacade itemDomainFacade;
    @InjectMocks
    private ItemCommandFacadeImpl itemCommandFacade;

    @Test
    public void shouldCreateNewItem() {
        //given
        var command = prepareAddTheHobbitCommand();
        var snapshot = createInitializedSnapshot(command);

        doReturn(snapshot)
                .when(itemDomainFacade)
                .createItem(any());

        //when
        var result = itemCommandFacade.createItem(command);

        //then
        assertEquals("Item successfully created!", result.getMessage());
    }

    @Test
    public void shouldDeleteItem() {
        //given
        var ISBN = createISBN();

        //when
        var result = itemCommandFacade.deleteItem(ISBN);

        //then
        assertEquals("Item successfully deleted!", result.getMessage());
    }

    @Test
    public void shouldUpdateItem() {
        //given
        var ISBN = createISBN();

        //when
        var result = itemCommandFacade.updateItem(ISBN);

        //then
        assertEquals("Item successfully updated!", result.getMessage());
    }

    @Test
    public void shouldCreateItemDetails() {
        //given
        var ISBN = createISBN();
        var command = prepareItemDetails();

        //when
        var result = itemCommandFacade.createItemDetails(ISBN, command);

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

    private ItemSnapshot createInitializedSnapshot(CreateItemCommand command) {
        return new ItemSnapshot(UUID.randomUUID().toString(), command.getISBN());
    }
}
