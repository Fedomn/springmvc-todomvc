package com.springapp.todomvc.services.impl;

import com.springapp.todomvc.domain.ToDo;
import com.springapp.todomvc.repository.ToDoRepository;
import com.springapp.todomvc.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {


    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> findAllToDos() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo findByTitle(String title) {
        return toDoRepository.findByTitle(title);
    }

    @Override
    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public void deleteById(String id) {
        toDoRepository.delete(id);
    }
    @Override
    public void updateToDo(ToDo toDo) {
        toDoRepository.updateToDo(toDo.getId(), toDo.getTitle(), toDo.getCompleted());
    }
}
