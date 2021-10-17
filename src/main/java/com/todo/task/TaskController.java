package com.todo.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/add-tasks")
    public String addUser(Task task) {
        if (taskService.addTask(task)) {
            return "add-task";
        }
        else{
            return "redirect:/home";
        }
    }

    @GetMapping("/view-tasks")
    public String viewTask(Model model) {
        model.addAttribute("taskList", taskService.viewTasks());
        return "view-task";
    }
}
