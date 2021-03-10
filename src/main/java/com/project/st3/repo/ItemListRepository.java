package com.project.st3.repo;

import com.project.st3.model.entity.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemListRepository extends JpaRepository<ItemList, Long> {
    ItemList findItemListById(Long id);
}
