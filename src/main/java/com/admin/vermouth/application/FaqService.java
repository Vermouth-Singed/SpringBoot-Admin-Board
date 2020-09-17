package com.admin.vermouth.application;

import com.admin.vermouth.domain.FaqVO;
import com.admin.vermouth.repository.FaqMapper;
import com.admin.vermouth.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FaqService {
    @Autowired
    FaqRepository faqRepository;

    @Autowired
    FaqMapper faqMapper;

    public FaqVO readOne(long id) {
        try{
            List<FaqVO> list = faqRepository.findById(id);

            if(list != null && list.size() > 0){
                return list.get(0);
            }else{
                return FaqVO.builder().build();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public List<FaqVO> readList(int pageNo, int rowSize) {
        try{
            return faqMapper.getFaqList((pageNo-1)*rowSize+1, pageNo*rowSize);
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public String createFaq(String title, String content, String userId) {
        try{
            FaqVO faq = FaqVO.builder().title(title).content(content).
                        userId(userId).updateDate(LocalDateTime.now()).
                        registerDate(LocalDateTime.now()).build();

            faqRepository.save(faq);

            return "success";
        }catch(Exception e){
            e.printStackTrace();
        }

        return "fail";
    }

    public String updateFaq(long id, String title, String content, String userId) {
        try{
            FaqVO param = readOne(id);

            if(param != null && param.getId() != 0){
                FaqVO faq = FaqVO.builder().id(id).title(title).content(content).
                        userId(userId).updateDate(LocalDateTime.now()).
                        registerDate(param.getRegisterDate()).build();

                faqRepository.save(faq);

                return "success";
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return "fail";
    }

    public String deleteFaq(long id) {
        try{
            FaqVO param = readOne(id);

            if(param != null && param.getId() != 0){
                faqRepository.delete(param);

                return "success";
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return "fail";
    }
}