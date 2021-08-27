package com.hmp.userservice.controller;

import com.hmp.userservice.VO.ResponseTemplateVO;
import com.hmp.userservice.entity.User;
import com.hmp.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    //@Requestbody to use post from postman
    public User saveUser(@RequestBody User user) {
        log.info("inside saveUser of userController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment of user controller");
        return userService.getUserWithDepartment(userId);
}
}
