package com.admin.vermouth.application;

import com.admin.vermouth.domain.UserVO;
import com.admin.vermouth.repository.UserRepository;
import com.admin.vermouth.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.admin.vermouth.configuration.SecurityConfig.passwordEncoder;

@Service
public class UserService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepository;

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

    public UserVO readOne(String id) {
        try{
            List<UserVO> list = userRepository.findByUserId(id);

            if(list != null && list.size() > 0){
                return list.get(0);
            }else{
                return UserVO.builder().build();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public Page<UserVO> readByUserIdStartingWithPagingList(int pageNo, int rowSize, String userId) {
        try{
            return userRepository.findByUserIdStartingWith(userId
                    , PageRequest.of(pageNo-1, rowSize, Sort.by("userId").and(Sort.by("userName")))
            );
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public Page<UserVO> readByUserIdPagingList(int pageNo, int rowSize, String userId) {
        try{
            return userRepository.findByUserId(userId
                    , PageRequest.of(pageNo-1, rowSize)
            );
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}