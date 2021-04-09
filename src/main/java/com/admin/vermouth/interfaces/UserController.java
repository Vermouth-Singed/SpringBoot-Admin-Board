package com.admin.vermouth.interfaces;

import com.admin.vermouth.application.UserService;
import com.admin.vermouth.domain.UserVO;
import com.admin.vermouth.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/one/{id}")
    public UserVO readOne(@PathVariable String id){
//        http get localhost:8080/api/user/one/user00
        return userService.readOne(id);
    }

    @GetMapping("/list/{pageNo}/{rowSize}/{userId}")
    public Page<UserVO> readByUserIdStartingWithPagingList(@PathVariable int pageNo, @PathVariable int rowSize, @PathVariable String userId){
//        http get localhost:8080/api/user/list/1/10/user0
        return userService.readByUserIdStartingWithPagingList(pageNo, rowSize, userId);
    }

    @GetMapping("/list/board/{pageNo}/{rowSize}/{userId}")
    public Page<UserVO> readByUserIdPagingList(@PathVariable int pageNo, @PathVariable int rowSize, @PathVariable String userId){
//        http get localhost:8080/api/user/list/board/1/10/user00
        return userService.readByUserIdPagingList(pageNo, rowSize, userId);
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
}