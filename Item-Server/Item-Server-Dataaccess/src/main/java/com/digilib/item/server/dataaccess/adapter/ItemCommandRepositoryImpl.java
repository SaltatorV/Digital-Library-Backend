package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.port.output.ItemCommandRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemCommandRepositoryImpl implements ItemCommandRepository {

    Set<ItemSnapshot> snapshots = new HashSet<>();

    @Override
    public Optional<ItemSnapshot> findByISBN(String ISBN) {
        return snapshots.stream()
                .filter(snapshot -> snapshot.getIsbn().equals(ISBN))
                .findFirst();
    }

    @Override
    public void save(ItemSnapshot snapshot) {
        snapshots.add(snapshot);
    }
    @Override
    public boolean existsByISBN(String isbn) {
        return snapshots
                .stream()
                .anyMatch(snapshot -> snapshot.getIsbn().equals(isbn));
    }

    @Override
    public void delete(String isbn) {
        Optional<ItemSnapshot> toDelete = snapshots
                .stream()
                .filter(snapshot -> snapshot.getIsbn().equals(isbn))
                .findFirst();

        toDelete.ifPresent(snapshot -> snapshots.remove(snapshot));
    }

    @Override
    public void update(ItemSnapshot snapshot) {

    }
}
