package com.admin.vermouth.dto;

import com.admin.vermouth.domain.UserVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends CommonDTO {
    private String userPassword;
    private String userName;
    private String jwt_token;
    private String jwt_key;

    private UserVO user;
}