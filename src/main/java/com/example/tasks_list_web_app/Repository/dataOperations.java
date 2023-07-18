package com.example.tasks_list_web_app.Repository;

import com.example.tasks_list_web_app.Entity.Priority;
import com.example.tasks_list_web_app.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface dataOperations extends JpaRepository<Task, Long> {

    @Query(value = "SELECT * FROM tasks", nativeQuery = true)
    ArrayList<Task> findAll();

    void deleteById(Long id);


}
