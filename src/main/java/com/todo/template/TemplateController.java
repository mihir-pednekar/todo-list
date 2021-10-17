package com.todo.template;

import com.todo.user.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class TemplateController {

    private final CustomUserDetailService customUserDetailService;

    @GetMapping("home")
    public String homeView(){
        return "home";
    }
}
