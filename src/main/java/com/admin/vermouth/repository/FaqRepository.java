package com.admin.vermouth.repository;

import com.admin.vermouth.domain.FaqVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaqRepository extends JpaRepository<FaqVO, Long> {
    List<FaqVO> findById(long id);
}