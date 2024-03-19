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
import org.springframework.stereotype.Service;

@Service
class ItemCommandFacadeImpl implements ItemCommandFacade {

    private final ItemDomainFacade itemDomainFacade;
    private final ItemCommandRepository repository;

    public ItemCommandFacadeImpl(ItemDomainFacade itemDomainFacade, ItemCommandRepository repository) {
        this.itemDomainFacade = itemDomainFacade;
        this.repository = repository;
    }

    @Override
    public MessageResponse createItem(CreateItemCommand command) {

        if(isbnExists(command.getISBN())) {
            throw new ItemAlreadyExistsException();
        }

        ItemSnapshot snapshot = new ItemSnapshot(command.getISBN(), command.getGenre(), command.getTitle(),
                command.getAuthor(), command.getPublisher(), command.getReleaseDate());

        ItemSnapshot initializedSnapshot = itemDomainFacade.createItem(snapshot);
        repository.save(initializedSnapshot);
        return MessageResponse.create("Item successfully created!");
    }

    @Override
    public MessageResponse deleteItem(String ISBN) {
        if(isbnNotExists(ISBN)) {
            throw new ItemNotFoundException();
        }

        repository.delete(ISBN);
        return MessageResponse.create("Item successfully deleted!");
    }

    @Override
    public MessageResponse updateItem(String ISBN, UpdateItemCommand command) {

        if(isbnNotExists(ISBN)) {
            throw new ItemNotFoundException();
        }

        ItemSnapshot snapshot = new ItemSnapshot(ISBN, command.getGenre(), command.getTitle(),
                command.getAuthor(), command.getPublisher(), command.getReleaseDate());

        repository.update(snapshot);

        return MessageResponse.create("Item successfully updated!");
    }

    @Override
    public MessageResponse createItemDetails(String isbn, CreateItemDetailsCommand command) {
        return MessageResponse.create("Item details successfully bounded!");
    }

    private boolean isbnExists(String ISBN) {
        return repository.findByISBN(ISBN).isPresent();
    }

    private boolean isbnNotExists(String ISBN) {
        return repository.findByISBN(ISBN).isEmpty();
    }
}
