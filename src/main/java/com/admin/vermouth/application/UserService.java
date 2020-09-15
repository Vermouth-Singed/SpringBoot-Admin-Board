package com.admin.vermouth.application;

import com.admin.vermouth.domain.UserVO;
import com.admin.vermouth.repository.UserMapper;
import com.admin.vermouth.repository.UserRepository;
import com.admin.vermouth.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.admin.vermouth.configuration.SecurityConfig.passwordEncoder;

@Service
public class UserService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserVO getLoginInfo(String userId, String userPassword) {
        Optional<UserVO> list = userRepository.
                findByUserIdAndUserPassword(userId,
                        passwordEncoder(userPassword)).stream().findFirst();

        if(list.isPresent()){
            UserVO user = list.get();

            user.setJwt_token(jwtUtil.createToken(user.getUserName()));
            user.setJwt_key(jwtUtil.getSecret());

            return user;
        }

        return UserVO.builder().build();
    }

    public String createUser(String userId, String userPassword, String userName) {
        try{
            UserVO user = UserVO.builder().userId(userId).
                    userPassword(passwordEncoder(userPassword)).
                    userName(userName).registerDate(LocalDateTime.now()).
                    updateDate(LocalDateTime.now()).build();

            userRepository.save(user);
        }catch(Exception e){
            e.printStackTrace();

            return "fail";
        }

        return "success";
    }

    public String updateUser(String userId, String userPassword, String userName) {
        try{
            Optional<UserVO> list = userRepository.findByUserId(userId).stream().findFirst();

            if(list.isPresent()){
                UserVO user = UserVO.builder().userId(userId).
                        userPassword(passwordEncoder(userPassword)).
                        userName(userName).registerDate(list.get().getRegisterDate()).
                        updateDate(LocalDateTime.now()).build();

                userRepository.save(user);
            }
        }catch(Exception e){
            e.printStackTrace();

            return "fail";
        }

        return "success";
    }

    public String deleteUser(String userId) {
        try{
            Optional<UserVO> list = userRepository.findByUserId(userId).stream().findFirst();

            list.ifPresent(user -> {
                userRepository.delete(user);
            });
        }catch(Exception e){
            e.printStackTrace();

            return "fail";
        }

        return "success";
    }
}