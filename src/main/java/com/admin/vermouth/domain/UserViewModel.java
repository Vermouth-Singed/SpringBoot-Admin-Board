package com.admin.vermouth.domain;

import lombok.Data;

@Data
public class UserViewModel {
    private String userId;
    private String userPassword;

    private UserVO user;
}