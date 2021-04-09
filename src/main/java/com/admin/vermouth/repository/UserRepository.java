package com.admin.vermouth.repository;

import com.admin.vermouth.domain.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserVO, String> {
    List<UserVO> findByUserIdAndUserPassword(String userId, String userPassword);
    List<UserVO> findByUserId(String userId);
    Page<UserVO> findByUserId(String userId, Pageable pageable);
    Page<UserVO> findByUserIdStartingWith(String userId, Pageable pageable);
}