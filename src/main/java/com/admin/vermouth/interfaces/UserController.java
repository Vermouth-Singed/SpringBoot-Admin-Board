package com.admin.vermouth.interfaces;

import com.admin.vermouth.application.UserService;
import com.admin.vermouth.domain.UserViewModel;
import com.admin.vermouth.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/login")
    public UserViewModel login(UserViewModel vm){
        System.out.println(">>>>>>"+vm.getUserId()+"//"+vm.getUserPassword());
        vm.setJwt(jwtUtil.createToken(vm.getUserId()));
        return vm;
    }
}