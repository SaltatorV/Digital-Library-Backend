package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.port.output.ItemQueryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemQueryRepositoryImpl implements ItemQueryRepository {
    Database db;

    public ItemQueryRepositoryImpl(Database db) {
        this.db = db;
    }

    @Override
    public Optional<ItemSnapshot> findByISBN(String ISBN) {
        return db.snapshots.stream()
                .filter(snapshot -> snapshot.getIsbn().equals(ISBN))
                .findFirst();
    }
}
