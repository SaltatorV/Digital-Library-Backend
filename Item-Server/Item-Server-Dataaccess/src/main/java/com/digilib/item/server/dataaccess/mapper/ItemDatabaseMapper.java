package com.digilib.item.server.dataaccess.mapper;

import com.digilib.item.server.dataaccess.entity.ItemEntity;
import com.digilib.item.server.domain.vo.ItemSnapshot;
import org.springframework.stereotype.Component;

@Component
public class ItemDatabaseMapper {

    public ItemSnapshot mapItemEntityToSnapshot(ItemEntity entity) {
        return new ItemSnapshot(entity.getItemId(), entity.getIsbn(), entity.getGenre(),
                entity.getTitle(), entity.getAuthor(), entity.getPublisher(), entity.getReleaseDate());
    }


    public ItemEntity mapItemSnapshotToEntity(ItemSnapshot snapshot) {
        return ItemEntity
                .builder()
                .itemId(snapshot.getId())
                .isbn(snapshot.getIsbn())
                .author(snapshot.getAuthor())
                .title(snapshot.getTitle())
                .genre(snapshot.getGenre())
                .publisher(snapshot.getPublisher())
                .releaseDate(snapshot.getReleaseDate())
                .build();
    }
}
