package com.example.tasks_list_web_app.Services;

import com.example.tasks_list_web_app.Entity.Priority;
import com.example.tasks_list_web_app.Entity.Task;
import com.example.tasks_list_web_app.Repository.dataOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MainService {

    @Autowired
    private dataOperations dataOperations;

    public void addTask(Task task) {
        dataOperations.save(task);
    }

    public void deleteTask(Task task) {
        dataOperations.delete(task);
    }

    public ArrayList<Task> viewAllTasks() {
        return dataOperations.findAll();
    }

    public void deleteById(Long id) {
        dataOperations.deleteById(id);
    }

//    public void updateById(Long id, String taskName, String description, Priority priority){
//        dataOperations.updateById(id,taskName,description,priority);
//    }

    public void update(Task task) {
        dataOperations.save(task);
    }

    public Task getById(Long id) {
        return dataOperations.getById(id);
    }
}
