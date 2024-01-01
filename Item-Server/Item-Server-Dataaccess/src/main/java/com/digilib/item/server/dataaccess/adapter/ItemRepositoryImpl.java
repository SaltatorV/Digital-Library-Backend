package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.port.output.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemRepositoryImpl implements ItemRepository {

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
}
