package com.admin.vermouth.interfaces;

import com.admin.vermouth.application.UserService;
import com.admin.vermouth.domain.UserVO;
import com.admin.vermouth.viewmodel.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public UserVO login(UserDTO vm, HttpSession session){
        UserVO user = userService.getLoginInfo(vm.getUserId(),vm.getUserPassword());

        session.setAttribute("jwt_token", user.getJwt_token());
        session.setAttribute("jwt_key", user.getJwt_key());

        return user;
    }

    @GetMapping("/check")
    public UserDTO check(UserDTO vm, HttpSession session){
        vm.setJwt_token((String)session.getAttribute("jwt_token"));
        vm.setJwt_key((String)session.getAttribute("jwt_key"));

        return vm;
    }

    @GetMapping("/logout")
    public void logout(HttpSession session){
        session.removeAttribute("jwt_token");
        session.removeAttribute("jwt_key");
    }

    @PostMapping("")
    public UserDTO create(@RequestBody UserDTO vm){
//        http post localhost:8080/api/user userId=vermouth userPassword=vermouth userName=버무스
        vm.setStatus(userService.createUser(vm.getUserId(), vm.getUserPassword(), vm.getUserName()));

        return vm;
    }

    @PutMapping("")
    public UserDTO update(@RequestBody UserDTO vm){
//        http put localhost:8080/api/user userId=vermouth userPassword=vermouth userName=버무스스2
        vm.setStatus(userService.updateUser(vm.getUserId(), vm.getUserPassword(), vm.getUserName()));

        return vm;
    }

    @DeleteMapping("")
    public UserDTO delete(UserDTO vm){
//        http delete localhost:8080/api/user?userId=vermouth
        vm.setStatus(userService.deleteUser(vm.getUserId()));

        return vm;
    }
}