package com.digilib.item.server.dataaccess.adapter;

import com.digilib.item.server.domain.vo.ItemSnapshot;
import com.digilib.item.server.service.port.output.ItemQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemQueryRepositoryImpl implements ItemQueryRepository {
    private final Database db;

    @Override
    public Optional<ItemSnapshot> findByISBN(String ISBN) {
        return db.snapshots.stream()
                .filter(snapshot -> snapshot.getIsbn().equals(ISBN))
                .findFirst();
    }
}
