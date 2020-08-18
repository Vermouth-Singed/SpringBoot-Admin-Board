package com.admin.vermouth.application;

import com.admin.vermouth.domain.UserVO;
import com.admin.vermouth.repository.UserMapper;
import com.admin.vermouth.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserMapper userMapper;

    public UserVO getLoginInfo(String userId, String userPassword) {
        UserVO user = userMapper.getLoginInfo(userId, userPassword);

        if(user != null){
            user.setJwt_token(jwtUtil.createToken(user.getUser_name()));
            user.setJwt_key(jwtUtil.getSecret());

            return user;
        }

        return new UserVO();
    }
}