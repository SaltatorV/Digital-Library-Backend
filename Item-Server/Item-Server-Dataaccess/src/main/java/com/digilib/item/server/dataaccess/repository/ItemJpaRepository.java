package com.digilib.item.server.dataaccess.repository;

import com.digilib.item.server.dataaccess.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemJpaRepository extends JpaRepository<ItemEntity, String> {
    Optional<ItemEntity> findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);

    void deleteByIsbn(String isbn);
}
