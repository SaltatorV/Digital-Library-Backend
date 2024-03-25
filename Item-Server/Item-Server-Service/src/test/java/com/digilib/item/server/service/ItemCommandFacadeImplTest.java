package com.digilib.item.server.service;

import com.digilib.item.server.domain.ItemDomainFacade;
import com.digilib.item.server.domain.exception.ItemAlreadyExistsException;
import com.digilib.item.server.domain.exception.ItemNotFoundException;
import com.digilib.item.server.domain.vo.Genre;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.builder.CreateItemCommandBuilder;
import com.digilib.item.server.service.builder.CreateItemDetailsCommandBuilder;
import com.digilib.item.server.service.builder.UpdateItemCommandBuilder;
import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;
import com.digilib.item.server.service.dto.command.UpdateItemCommand;
import com.digilib.item.server.service.dto.response.MessageResponse;
import com.digilib.item.server.service.port.output.ItemCommandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ItemCommandFacadeImplTest {

    @Mock
    private ItemDomainFacade itemDomainFacade;
    @Mock
    private ItemCommandRepository itemCommandRepository;
    @InjectMocks
    private ItemCommandFacadeImpl itemCommandFacade;

    @Test
    public void shouldCreateNewItem() {
        //given
        var command = CreateItemCommandBuilder.build()
                .withIsbn("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();
        
        
        returnEmptyWhenCheckIsbnExists(command.getIsbn());
        returnInitializedSnapshotFromDomain(command);
        
        //when
        var result = createItem(command);

        //then
        assertMessageIsSuccessfullyCreated(result);
    }

    @Test
    public void shouldThrowItemAlreadyExistsExceptionWhenCreateItem() {
        //given
        var command = CreateItemCommandBuilder.build()
                .withIsbn("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        returnSnapshotWhenCheckIsbnExists(command);

        //when
        assertThrowsItemAlreadyExistsExceptionWhenCreateItem(command);
    }

    @Test
    public void shouldDeleteItem() {
        //given
        var isbn = "0-061-96436-0";

        returnSnapshotWhenCheckIsbnExists(isbn);

        //when
        var result = deleteItem(isbn);

        //then
        assertMessageIsSuccessfullyDeleted(result);
    }

    @Test
    public void shouldThrowItemNotFoundExceptionWhenDeleteItem() {
        //given
        var isbn = "0-061-96436-0";

        returnEmptyWhenCheckIsbnExists(isbn);

        //when
        assertThrowsItemNotFoundExceptionWhenDeleteItem(isbn);
    }

    @Test
    public void shouldUpdateItem() {
        //given
        var isbn = "978-0547928227";

        var updateCommand = UpdateItemCommandBuilder.build()
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        var createItemCommand = CreateItemCommandBuilder.build()
                .withIsbn("978-0547928227")
                .withGenre("Fantasy")
                .withTitle("The")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        returnSnapshotWhenCheckIsbnExists(createItemCommand);

        //when
        var result = updateItem(isbn, updateCommand);

        //then
        assertMessageIsSuccessfullyUpdated(result);
    }

    @Test
    public void shouldThrowItemNotFoundExceptionWhenUpdateItem() {
        //given
        var isbn = "978-0547928227";

        var updateCommand = UpdateItemCommandBuilder.build()
                .withGenre("Fantasy")
                .withTitle("The Hobbit: Or There and Back Again")
                .withAuthor("J.R.R. Tolkien")
                .withPublisher("William Morrow & Company")
                .withReleaseDateInFormatDDMMYYYY("18102012")
                .create();

        returnEmptyWhenCheckIsbnExists(isbn);


        //when
        assertThrowsItemNotFoundExceptionWhenUpdateItem(isbn, updateCommand);
    }

    @Test
    public void shouldCreateItemDetails() {
        //given
        var isbn = "0-061-96436-0";
        var command = CreateItemDetailsCommandBuilder.build()
                .withQuantity(5)
                .withImgLink("example.com")
                .withHeight(100)
                .withThickness(40)
                .withWidth(80)
                .create();

        //when
        var result = createItemDetails(isbn, command);

        //then
        assertMessageIsSuccessfullyBounded(result);
    }

    private void returnEmptyWhenCheckIsbnExists(String isbn) {
        doReturn(Optional.empty())
                .when(itemCommandRepository)
                .findByIsbn(isbn);
    }


    private void returnSnapshotWhenCheckIsbnExists(CreateItemCommand command) {
        doReturn(Optional.of(createInitializedSnapshot(command)))
                .when(itemCommandRepository)
                .findByIsbn(command.getIsbn());
    }

    private void returnSnapshotWhenCheckIsbnExists(String isbn) {
        doReturn(Optional.of(createRandomSnapshot(isbn)))
                .when(itemCommandRepository)
                .findByIsbn(isbn);
    }

    private void returnInitializedSnapshotFromDomain(CreateItemCommand command) {
        doReturn(createInitializedSnapshot(command))
                .when(itemDomainFacade)
                .createItem(any());
    }

    private ItemSnapshot createInitializedSnapshot(CreateItemCommand command) {
        return new ItemSnapshot(UUID.randomUUID().toString(), command.getIsbn(), command.getGenre(),
                command.getTitle(), command.getAuthor(), command.getPublisher(), command.getReleaseDate());
    }

    private ItemSnapshot createRandomSnapshot(String isbn) {
        return new ItemSnapshot(UUID.randomUUID().toString(), isbn, Genre.BIOGRAPHY.getName(),
                "Title", "Author", "Publisher", Date.from(Instant.now()));
    }

    private MessageResponse createItem(CreateItemCommand command) {
        return itemCommandFacade.createItem(command);
    }

    private MessageResponse deleteItem(String isbn) {
        return itemCommandFacade.deleteItem(isbn);
    }

    private MessageResponse updateItem(String isbn, UpdateItemCommand updateCommand) {
        return itemCommandFacade.updateItem(isbn, updateCommand);
    }

    private MessageResponse createItemDetails(String isbn, CreateItemDetailsCommand command) {
        return itemCommandFacade.createItemDetails(isbn, command);
    }

    private void assertMessageIsSuccessfullyCreated(MessageResponse result) {
        assertEquals("Item successfully created!", result.getMessage());
    }

    private void assertMessageIsSuccessfullyDeleted(MessageResponse result) {
        assertEquals("Item successfully deleted!", result.getMessage());
    }

    private void assertMessageIsSuccessfullyUpdated(MessageResponse result) {
        assertEquals("Item successfully updated!", result.getMessage());
    }

    private void assertMessageIsSuccessfullyBounded(MessageResponse result) {
        assertEquals("Item details successfully bounded!", result.getMessage());
    }

    private void assertThrowsItemAlreadyExistsExceptionWhenCreateItem(CreateItemCommand command) {
        assertThrows(ItemAlreadyExistsException.class, () -> itemCommandFacade.createItem(command));
    }

    private void assertThrowsItemNotFoundExceptionWhenDeleteItem(String isbn) {
        assertThrows(ItemNotFoundException.class, () -> itemCommandFacade.deleteItem(isbn));
    }

    private void assertThrowsItemNotFoundExceptionWhenUpdateItem(String isbn, UpdateItemCommand updateCommand) {
        assertThrows(ItemNotFoundException.class, () -> itemCommandFacade.updateItem(isbn, updateCommand));
    }
}
