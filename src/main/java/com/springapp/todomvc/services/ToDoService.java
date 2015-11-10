package com.springapp.todomvc.services;

import com.springapp.todomvc.domain.ToDo;

import java.util.List;

public interface ToDoService {

    List<ToDo> findAllToDos();

    ToDo findByTitle(String name);

    ToDo save(ToDo toDo);

    void deleteById(String id);

    void updateToDo(ToDo toDo);

}
