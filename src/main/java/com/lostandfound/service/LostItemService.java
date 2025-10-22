package com.lostandfound.service;

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


}