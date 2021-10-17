//package com.todo.template;
//
//import com.todo.user.CustomUserDetailService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/")
//@RequiredArgsConstructor
//@Slf4j
//public class TemplateController {
//
//    private final CustomUserDetailService customUserDetailService;
//
//    @PostMapping(value = "login-user")
//    public String postLoginUser(@RequestParam(value = "username") String username,
//                               @RequestParam(name = "password") String password ){
//
//        if(username != null && username.equals("test")){
//            if(customUserDetailService.createDefaultUser(username)){
//                log.info("Default user created.");
//            }
//            else{
//                log.error("Failed to create default user.");
//            }
//        }
//        return "home";
//    }
//
//    @GetMapping("login")
//    public String loginView(){
//        return "login";
//    }
//
//    @GetMapping("home")
//    public String homeView(){
//        return "home";
//    }
//}
