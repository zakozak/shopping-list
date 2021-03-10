package com.project.st3.controller;

import com.project.st3.model.dto.ItemListDto;
import com.project.st3.service.ItemListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/lists")
public class ItemListController {

    private final ItemListService itemListService;

    public ItemListController(ItemListService itemListService) {
        this.itemListService = itemListService;
    }

    @GetMapping
    public ResponseEntity<List<ItemListDto>> getItemLists() {
        return ResponseEntity.ok(itemListService.getItemLists());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createItemList(@RequestBody ItemListDto itemListDto) {
        itemListService.createItemList(itemListDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateItemList(@PathVariable("id") Long itemListId, @RequestBody ItemListDto itemListDetails) {
        itemListService.updateItemList(itemListDetails, itemListId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteItemList(@PathVariable("id") Long id) {
        itemListService.deleteItemList(id);
        return ResponseEntity.noContent().build();
    }
}
