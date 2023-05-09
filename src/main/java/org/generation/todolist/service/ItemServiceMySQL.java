package org.generation.todolist.service;

import org.generation.todolist.repository.ItemRepository;
import org.generation.todolist.repository.entity.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class ItemServiceMySQL implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceMySQL(@Autowired ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }


    @Override
    public List save(List item)
    {
       return itemRepository.save(item);
    }


    @Override
    public void delete(int itemId)
    {
        itemRepository.deleteById(itemId);

    }


    @Override
    public ArrayList<List> all()
    {
        ArrayList<List> result = new ArrayList<>();
        itemRepository.findAll().forEach(result::add);
        return result;
    }


    @Override
    public List findById(int itemId)
    {
        Optional<List> item = itemRepository.findById(itemId);
        List itemResponse = item.get();
        return itemResponse;
    }
}

