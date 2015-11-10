package com.springapp.todomvc.repository;

import com.springapp.todomvc.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ToDoRepository extends JpaRepository<ToDo, String>{

    ToDo findByTitle(String title);

    @Modifying
    @Query("update ToDo todo set todo.title = ?2, todo.completed = ?3 where todo.id = ?1")
    void updateToDo(String id, String title, Boolean completed);
}
