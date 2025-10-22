package com.lostandfound.controller;

import com.lostandfound.model.LostItem;
import com.lostandfound.repository.LostItemRepository;
import com.lostandfound.service.LostItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}