package com.todo.template;

import com.todo.task.TaskService;
import com.todo.user.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class TemplateController {

    private final TaskService taskService;

    @GetMapping("home")
    public String homeView(Model model) {
        model.addAttribute("taskList", taskService.viewTasks());
        return "home";
    }
}
