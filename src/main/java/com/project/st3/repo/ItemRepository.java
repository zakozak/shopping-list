package com.project.st3.repo;

import com.project.st3.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemById(Long id);
    List<Item> findItemsByItemListId(Long id);
}
