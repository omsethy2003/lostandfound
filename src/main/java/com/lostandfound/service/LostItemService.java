package com.lostandfound.service;

import com.lostandfound.exception.ResourceNotFoundException;
import com.lostandfound.model.LostItem;
import com.lostandfound.repository.LostItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LostItemService {

    private final LostItemRepository lostItemRepository;

    public List<LostItem> getAllItems() {
        return lostItemRepository.findAll();
    }

    public LostItem createItem(LostItem item) {
        if(item.getDateReported() == null) {
            item.setDateReported(LocalDate.now());
        }
        return lostItemRepository.save(item);
    }

    public LostItem getItemById(Long id) {
        return lostItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));
    }

    public LostItem updateItem(Long id, LostItem itemDetails) {
        LostItem existingItem = getItemById(id);
        existingItem.setTitle(itemDetails.getTitle());
        existingItem.setDescription(itemDetails.getDescription());
        existingItem.setCategory(itemDetails.getCategory());
        existingItem.setLocation(itemDetails.getLocation());
        existingItem.setFound(itemDetails.isFound());
        return lostItemRepository.save(existingItem);
    }

    public void deleteItem(Long id) {
        LostItem existingItem = getItemById(id);
        lostItemRepository.delete(existingItem);
    }


}