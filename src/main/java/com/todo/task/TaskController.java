package com.todo.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/add-tasks")
    public String addTask(@ModelAttribute Task task) {
        if (taskService.addTask(task)) {
            return "redirect:/tasks/view-tasks";
        }
        else{
            return "add-task";
        }
    }

    @GetMapping("/add-tasks")
    public String viewAddTask(Model model) {
        model.addAttribute("task", new Task());
        return "add-task";
    }

    @GetMapping("/view-tasks")
    public String viewTask(Model model) {
        model.addAttribute("taskList", taskService.viewTasks());
        return "view-task";
    }

    @PostMapping("/close-tasks")
    public String closeTask(@RequestParam(value = "check") Long taskId) {
        if (taskService.closeTask(taskId)) {
            return "redirect:/home";
        }
        else{
            return "redirect:/tasks/view-tasks";
        }
    }
}
