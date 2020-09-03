package com.admin.vermouth.domain;

import lombok.Data;

@Data
public class UserViewModel {
    private String userId;
    private String userPassword;
    private String userName;
    private String jwt_token;
    private String jwt_key;
    private String status;

    private UserVO user;
}