package com.example.tasks_list_web_app.Controllers;


import com.example.tasks_list_web_app.Entity.Priority;
import com.example.tasks_list_web_app.Entity.Task;
import com.example.tasks_list_web_app.Services.MainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/tasks")
public class MainController {


    @Autowired
    private MainService service;

    private Long editId;

    private String warningMessage = "You must choose a task to edit!";


    @GetMapping("/addToList")
    public String add(Model model) {
        model.addAttribute("testList", service.viewAllTasks());
        return "addList";
    }

    @PostMapping("/addToList")
    public String add(@Valid String taskName, @Valid String description, @Valid Priority priority) {

        Task task = new Task();
        task.setTaskName(taskName);
        task.setDescription(description);
        task.setPriority(priority);
        service.addTask(task);
        return "redirect:/tasks/addToList";
    }


    @GetMapping("/remove")
    public String removeElements(Model model) {
        model.addAttribute("testList", service.viewAllTasks());

        return "remove";
    }

    @PostMapping("/remove")
    public String removeElements(@RequestParam("selected") ArrayList<String> selected) {
        for (String value : selected) {
            service.deleteById(Long.parseLong(value));
        }
        return "redirect:/tasks/addToList";
    }

    @GetMapping("/chooseItem")
    public String chooseToEditItem(Model model) {
        model.addAttribute("testList", service.viewAllTasks());
        return "chooseToEdit";
    }

    @PostMapping("/chooseItem")
    public String chooseToEditItem(@RequestParam(value = "taskIdEdit", required = false) Long id, Model model) {
        editId = id;
        if (editId == null) {
            model.addAttribute("message", warningMessage);
            model.addAttribute("testList", service.viewAllTasks());
            return "redirect:/tasks/chooseItem";
        }
        return "redirect:/tasks/edit";
    }


    @GetMapping("/edit")
    public String editItem(Model model) {
        model.addAttribute("testList", service.viewAllTasks());
        model.addAttribute("editableId", editId);
        System.out.println(editId);
        return "editItem";
    }

    @PostMapping("/edit")
    public String editItem(@RequestParam(value = "") String editedTaskName, String editedTaskDescription, Priority editedTaskPriority, Model model) {
        Task task = service.getById(editId);
        task.setTaskName(editedTaskName);
        task.setDescription(editedTaskDescription);
        task.setPriority(editedTaskPriority);
        service.update(task);
        return "redirect:/tasks/addToList";

    }


    @GetMapping("/{id}")
    public String redirection(@PathVariable(value = "id") String id) {
        return "redirect:/tasks/addToList";
    }


}
