package org.generation.todolist.service;

import org.generation.todolist.repository.entity.List;

import java.util.ArrayList;

public interface ItemService {

    //save method is for 2 purposes - Create new item & Update existing item
    List save(List item);


    //Delete item from database - based on item Id
    void delete(int itemId);


    //Read all item from database
    ArrayList<List> all();


    //Read an item from database - based on item Id
    List findById(int itemId);

}
