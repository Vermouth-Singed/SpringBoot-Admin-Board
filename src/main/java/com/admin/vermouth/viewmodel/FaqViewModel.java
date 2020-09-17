package com.admin.vermouth.viewmodel;

import com.admin.vermouth.domain.FaqVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FaqViewModel extends CommonViewModel{
    private String title;
    private String content;

    private FaqVO faqVO;
    private List<FaqVO> faqVOList;
}