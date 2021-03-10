package com.project.st3.service.impl;

import com.project.st3.model.dto.ItemDto;
import com.project.st3.model.entity.Item;
import com.project.st3.repo.ItemListRepository;
import com.project.st3.repo.ItemRepository;
import com.project.st3.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemListRepository itemListRepository;

    public ItemServiceImpl(ItemRepository itemRepository, ItemListRepository itemListRepository) {
        this.itemRepository = itemRepository;
        this.itemListRepository = itemListRepository;
    }

    @Override
    public void createItem(ItemDto itemDto, Long listId) {
        Item item = new Item();
        BeanUtils.copyProperties(itemDto, item);
        item.setCreationTime(new Date());
        item.setItemListId(itemListRepository.findItemListById(listId));
        itemRepository.save(item);
    }

    @Override
    public ItemDto getItem(Long id) {
        Item item = itemRepository.findItemById(id);
        ItemDto itemDto = new ItemDto();
        BeanUtils.copyProperties(item, itemDto);
        return itemDto;
    }

    @Override
    public List<ItemDto> getItems(Long id) {
        List<ItemDto> itemsDtoList = new ArrayList<>();
        List<Item> itemsList = itemRepository.findItemsByItemListId(id);
        for (Item item : itemsList) {
            ItemDto itemDto = new ItemDto();
            itemDto.setContent(item.getContent());
            itemsDtoList.add(itemDto);
        }
        return itemsDtoList;
    }

    @Override
    public void updateItem(ItemDto itemDto, Long id) {
        Item item = itemRepository.findItemById(id);
        item.setContent(itemDto.getContent());
        item.setBought(itemDto.isBought());
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        Item item = itemRepository.findItemById(id);
        itemRepository.delete(item);
    }
}
