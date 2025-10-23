package com.lostandfound.controller;

import com.lostandfound.model.LostItem;
import com.lostandfound.repository.LostItemRepository;
import com.lostandfound.service.LostItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class LostItemController {

    private final LostItemService lostItemService;

    @GetMapping
    public List<LostItem> getAllItems() {
        return lostItemService.getAllItems();
    }

    @PostMapping
    public LostItem createItem(@RequestBody LostItem item) {
        return lostItemService.createItem(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LostItem> getItemById(@PathVariable Long id) {
        LostItem item = lostItemService.getItemById(id);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LostItem> updateItem(@PathVariable Long id, @RequestBody LostItem itemDetails) {
        LostItem updatedItem = lostItemService.updateItem(id, itemDetails);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable Long id) {
        lostItemService.deleteItem(id);
        Map<String, Boolean> response = Map.of("deleted", true);
        return ResponseEntity.ok(response);
    }
}