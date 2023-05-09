package org.generation.todolist.controller;

import org.generation.todolist.repository.entity.List;
import org.generation.todolist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Value;
import org.generation.todolist.component.FileUploadUtil;
import org.generation.todolist.controller.dto.ItemDTO;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;


    public ItemController( @Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }


    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<List> getItems()
    {
        return itemService.all();
    }
    @CrossOrigin
    @GetMapping( "/{id}" )
    public List findItemById( @PathVariable Integer id )
    {
        return itemService.findById( id );
    }


    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="targetdate", required = true) String targetdate)
//                        @RequestParam("datepicker") @DateTimeFormat(pattern="ddmmyyyy") LocalDate datepicker)
    {

        ItemDTO itemDto = new ItemDTO(title, description, targetdate);
        itemService.save(new List(itemDto));

    }
}

