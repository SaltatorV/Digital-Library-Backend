package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.port.output.ItemCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ItemCommandRepositoryImpl implements ItemCommandRepository {

    private final Database db;

    @Override
    public void save(ItemSnapshot snapshot) {
        db.snapshots.add(snapshot);
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
        db.snapshots.removeIf(s -> s.getIsbn().equals(snapshot.getIsbn()));
        db.snapshots.add(snapshot);
    }

    @Override
    public Optional<ItemSnapshot> findByISBN(String ISBN) {
        return db.snapshots.stream().filter(snapshot -> snapshot.getIsbn().equals(ISBN)).findFirst();
    }
}
