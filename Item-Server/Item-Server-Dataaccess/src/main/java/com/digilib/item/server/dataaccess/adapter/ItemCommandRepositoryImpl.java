package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.port.output.ItemCommandRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemCommandRepositoryImpl implements ItemCommandRepository {

    Database db;

    public ItemCommandRepositoryImpl(Database db) {
        this.db = db;
    }

    @Override
    public void save(ItemSnapshot snapshot) {
        db.snapshots.add(snapshot);
    }
    @Override
    public boolean existsByISBN(String isbn) {
        return db.snapshots
                .stream()
                .anyMatch(snapshot -> snapshot.getIsbn().equals(isbn));
    }

    @Override
    public void delete(String isbn) {
        Optional<ItemSnapshot> toDelete = db.snapshots
                .stream()
                .filter(snapshot -> snapshot.getIsbn().equals(isbn))
                .findFirst();

        toDelete.ifPresent(snapshot -> db.snapshots.remove(snapshot));
    }

    @Override
    public void update(ItemSnapshot snapshot) {

    }
}