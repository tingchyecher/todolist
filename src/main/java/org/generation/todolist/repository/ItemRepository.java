package org.generation.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.generation.todolist.repository.entity.List;

public interface ItemRepository extends CrudRepository<List, Integer>{


}
