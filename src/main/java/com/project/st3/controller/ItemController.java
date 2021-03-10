package com.project.st3.controller;

import com.project.st3.model.dto.ItemDto;
import com.project.st3.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists/{listId}/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getItem(@PathVariable("id") Long id) {
        return ResponseEntity.ok(itemService.getItem(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> getItems(@PathVariable Long listId) {
        return ResponseEntity.ok(itemService.getItems(listId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createItem(@PathVariable Long listId, @RequestBody ItemDto itemDto) {
        itemService.createItem(itemDto, listId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateBoard(@PathVariable("id") Long itemId, @RequestBody ItemDto itemDetails) {
        itemService.updateItem(itemDetails, itemId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

}
