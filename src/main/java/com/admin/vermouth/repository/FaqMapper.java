package com.admin.vermouth.repository;

import com.admin.vermouth.domain.FaqVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FaqMapper {
    List<FaqVO> getFaqList(int first, int last);
}