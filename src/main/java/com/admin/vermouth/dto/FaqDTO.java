package com.admin.vermouth.dto;

import com.admin.vermouth.domain.FaqVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FaqDTO extends CommonDTO {
    private String title;
    private String content;

    private FaqVO faqVO;
    private List<FaqVO> faqVOList;
}