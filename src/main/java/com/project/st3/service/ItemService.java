package com.project.st3.service;

import com.project.st3.model.dto.ItemDto;

import java.util.List;

public interface ItemService {
    void createItem(ItemDto item, Long listId);

    ItemDto getItem(Long id);

    List<ItemDto> getItems(Long id); //TODO айтемы листа интемов из урл

    void updateItem(ItemDto itemDto, Long id);

    void deleteItem(Long id);
}
