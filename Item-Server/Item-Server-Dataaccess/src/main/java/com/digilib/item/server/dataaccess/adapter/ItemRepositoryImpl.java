package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.dataaccess.mapper.ItemDatabaseMapper;
import com.digilib.item.server.dataaccess.repository.ItemJpaRepository;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.port.output.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemJpaRepository itemRepository;
    private final ItemDatabaseMapper mapper;

    @Override
    public Optional<ItemSnapshot> findByISBN(String ISBN) {
        return itemRepository.findByIsbn(ISBN)
                .map(mapper::mapItemEntityToSnapshot);
    }

    @Override
    public void save(ItemSnapshot snapshot) {
        itemRepository.save(mapper.mapItemSnapshotToEntity(snapshot));
    }
    @Override
    public boolean existsByISBN(String isbn) {
        return itemRepository.existsByIsbn(isbn);
    }

    @Override
    public void delete(String isbn) {
       itemRepository.deleteByIsbn(isbn);
    }
}
