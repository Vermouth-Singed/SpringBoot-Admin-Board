package com.admin.vermouth.interfaces;

import com.admin.vermouth.application.UserService;
import com.admin.vermouth.domain.UserVO;
import com.admin.vermouth.domain.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public UserVO login(UserViewModel vm, HttpSession session){
        UserVO user = userService.getLoginInfo(vm.getUserId(),vm.getUserPassword());

        session.setAttribute("jwt_token", user.getJwt_token());
        session.setAttribute("jwt_key", user.getJwt_key());

        return user;
    }
}