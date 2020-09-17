package com.admin.vermouth.viewmodel;

import com.admin.vermouth.domain.UserVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserViewModel extends CommonViewModel{
    private String userPassword;
    private String userName;
    private String jwt_token;
    private String jwt_key;

    private UserVO user;
}