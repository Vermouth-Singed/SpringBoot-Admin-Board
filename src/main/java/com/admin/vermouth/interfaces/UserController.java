package com.admin.vermouth.interfaces;

import com.admin.vermouth.application.UserService;
import com.admin.vermouth.domain.UserVO;
import com.admin.vermouth.domain.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public UserVO login(UserViewModel vm){
        return userService.getLoginInfo(vm.getUserId(),vm.getUserPassword());
    }
}