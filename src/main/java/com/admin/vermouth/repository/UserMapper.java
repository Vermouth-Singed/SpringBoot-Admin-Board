package com.admin.vermouth.repository;

import com.admin.vermouth.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper{
    UserVO getLoginInfo(String user_id, String user_password);
}