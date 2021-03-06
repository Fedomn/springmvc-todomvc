package com.springapp.todomvc.repository;


import com.springapp.todomvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {

    @Modifying
    @Query("delete from User u where u.id = ?1")
    void deleteById(String id);

    User findByName(String name);
}
