package org.generation.todolist.repository.entity;

import org.generation.todolist.controller.dto.ItemDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import jakarta.persistence.*;

@Entity
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;             //retrieve product item by ID - has to be an object
    private String title;
    private String description;
    private String targetdate;



    public List() {}


    public List(ItemDTO itemDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.title = itemDTO.getTitle();
        this.description = itemDTO.getDescription();
        this.targetdate = itemDTO.getTargetdate();

    }


    public Integer getId()
    {
        return id;
    }


    public void setId( Integer id )
    {
        this.id = id;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle( String title )
    {
        this.title = title;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription( String description )
    {
        this.description = description;
    }


    public String getTargetdate()
    {
        return targetdate;
    }


    public void setTargetdate( String targetdate )
    {
        this.targetdate = targetdate;
    }





    @Override
    public String toString()
    {
        return "List{" + "id=" + id + ", title='" + title + '\'' + ", description='" +
                description + '\'' + ", targetdate='"
                + targetdate + '\''+'}';
    }
}

