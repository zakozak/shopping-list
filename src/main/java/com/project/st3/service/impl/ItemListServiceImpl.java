package com.project.st3.service.impl;

import com.project.st3.model.dto.ItemListDto;
import com.project.st3.model.entity.ItemList;
import com.project.st3.repo.ItemListRepository;
import com.project.st3.service.ItemListService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemListServiceImpl implements ItemListService {
    private final ItemListRepository itemListRepository;

    public ItemListServiceImpl(ItemListRepository itemListRepository) {
        this.itemListRepository = itemListRepository;
    }

    @Override
    public List<ItemListDto> getItemLists() {
        List<ItemListDto> itemListsDtoList = new ArrayList<>();
        List<ItemList> itemLists = itemListRepository.findAll();
        for (ItemList itemList : itemLists) {
            ItemListDto itemListDto = new ItemListDto();
            itemListDto.setDescription(itemList.getDescription());
            itemListsDtoList.add(itemListDto);
        }
        return itemListsDtoList;
    }

    @Override
    public void createItemList(ItemListDto itemListDto) {
        ItemList itemList = new ItemList();
        BeanUtils.copyProperties(itemListDto,itemList);
        itemList.setCreationDate(new Date());
        itemListRepository.save(itemList);
    }

    @Override
    public void updateItemList(ItemListDto itemListDto, Long id) {
        ItemList itemList = itemListRepository.findItemListById(id);
        itemList.setDescription(itemListDto.getDescription());
        itemListRepository.save(itemList);
    }

    @Override
    public void deleteItemList(Long id) {
        ItemList itemList = itemListRepository.findItemListById(id);
        itemListRepository.delete(itemList);
    }
}
