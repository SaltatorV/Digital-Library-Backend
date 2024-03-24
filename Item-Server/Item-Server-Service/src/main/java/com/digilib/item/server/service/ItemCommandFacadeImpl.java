package com.digilib.item.server.service;

import com.digilib.item.server.domain.ItemDomainFacade;
import com.digilib.item.server.domain.exception.ItemAlreadyExistsException;
import com.digilib.item.server.domain.exception.ItemNotFoundException;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.dto.command.CreateItemCommand;
import com.digilib.item.server.service.dto.command.CreateItemDetailsCommand;
import com.digilib.item.server.service.dto.command.UpdateItemCommand;
import com.digilib.item.server.service.dto.response.MessageResponse;
import com.digilib.item.server.service.port.input.ItemCommandFacade;
import com.digilib.item.server.service.port.output.ItemCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ItemCommandFacadeImpl implements ItemCommandFacade {

    private final ItemDomainFacade itemDomainFacade;
    private final ItemCommandRepository repository;

    @Override
    public MessageResponse createItem(CreateItemCommand command) {

        if(isbnExists(command.getIsbn())) {
            throw ItemAlreadyExistsException.createForIsbn(command.getIsbn());
        }

        ItemSnapshot snapshot = new ItemSnapshot(command.getIsbn(), command.getGenre(), command.getTitle(),
                command.getAuthor(), command.getPublisher(), command.getReleaseDate());

        ItemSnapshot initializedSnapshot = itemDomainFacade.createItem(snapshot);
        repository.save(initializedSnapshot);
        return MessageResponse.create("Item successfully created!");
    }

    @Override
    public MessageResponse deleteItem(String isbn) {
        if(isbnNotExists(isbn)) {
            throw ItemNotFoundException.createForIsbn(isbn);
        }

        repository.delete(isbn);
        return MessageResponse.create("Item successfully deleted!");
    }

    @Override
    public MessageResponse updateItem(String isbn, UpdateItemCommand command) {

        if(isbnNotExists(isbn)) {
            throw ItemNotFoundException.createForIsbn(isbn);
        }

        ItemSnapshot snapshot = new ItemSnapshot(isbn, command.getGenre(), command.getTitle(),
                command.getAuthor(), command.getPublisher(), command.getReleaseDate());

        repository.update(snapshot);

        return MessageResponse.create("Item successfully updated!");
    }

    @Override
    public MessageResponse createItemDetails(String isbn, CreateItemDetailsCommand command) {
        return MessageResponse.create("Item details successfully bounded!");
    }

    private boolean isbnExists(String isbn) {
        return repository.findByIsbn(isbn).isPresent();
    }

    private boolean isbnNotExists(String isbn) {
        return repository.findByIsbn(isbn).isEmpty();
    }
}
