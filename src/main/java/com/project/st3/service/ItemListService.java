package com.project.st3.service;

import com.project.st3.model.dto.ItemListDto;

import java.util.List;

public interface ItemListService {
    void createItemList(ItemListDto itemListDto);

    void deleteItemList(Long id);

    void updateItemList(ItemListDto itemListDto, Long id);

    List<ItemListDto> getItemLists();

}