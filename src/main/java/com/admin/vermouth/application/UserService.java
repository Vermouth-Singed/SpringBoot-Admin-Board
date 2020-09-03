package com.admin.vermouth.application;

import com.admin.vermouth.domain.UserVO;
import com.admin.vermouth.repository.UserMapper;
import com.admin.vermouth.repository.UserRepository;
import com.admin.vermouth.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserMapper userMapper;

    public UserVO getLoginInfo(String userId, String userPassword) {
        UserVO user = userMapper.getLoginInfo(userId, userPassword);

//        Optional<UserVO> user = userRepository.
//                findByUserIdAndUserPassword(userId,
//                        passwordEncoder.encode(userPassword)).stream().findFirst();
//        System.out.println(user);
//        System.out.println(userId+">>"+userPassword+">>"+passwordEncoder.encode(userPassword));

        if(user != null){
            user.setJwt_token(jwtUtil.createToken(user.getUserName()));
            user.setJwt_key(jwtUtil.getSecret());

            return user;
        }

        return UserVO.builder().build();
    }

    public String createUser(String userId, String userPassword, String userName) {
        String result = "success";

        try{
            UserVO user = UserVO.builder().userId(userId).
                            userPassword(passwordEncoder.encode(userPassword)).
                            userName(userName).build();

            userRepository.save(user);
        }catch(Exception e){
            e.printStackTrace();

            result = "fail";
        }

        return result;
    }
}