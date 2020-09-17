package com.admin.vermouth.interfaces;

import com.admin.vermouth.application.FaqService;
import com.admin.vermouth.domain.FaqVO;
import com.admin.vermouth.viewmodel.FaqViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faq")
public class FaqController {
    @Autowired
    FaqService faqService;

    @GetMapping("/one/{id}")
    public FaqVO readOne(@PathVariable long id){
//        http get localhost:8080/api/faq/one/1
        return faqService.readOne(id);
    }

    @GetMapping("/list/{pageNo}/{rowSize}")
    public List<FaqVO> readList(@PathVariable int pageNo, @PathVariable int rowSize){
//        http get localhost:8080/api/faq/list/1/10
        return faqService.readList(pageNo, rowSize);
    }

    @PostMapping("")
    public FaqViewModel create(@RequestBody FaqViewModel vm){
//        http post localhost:8080/api/faq title=제목2 content=내용2 userId=admin
        vm.setStatus(faqService.createFaq(vm.getTitle(), vm.getContent(), vm.getUserId()));

        return vm;
    }

    @PutMapping("")
    public FaqViewModel update(@RequestBody FaqViewModel vm){
//        http put localhost:8080/api/faq id=2 title=제목3 content=내용3 userId=admin
        vm.setStatus(faqService.updateFaq(vm.getId(), vm.getTitle(), vm.getContent(), vm.getUserId()));

        return vm;
    }

    @DeleteMapping("")
    public FaqViewModel delete(FaqViewModel vm){
//        http delete localhost:8080/api/faq?id=6
        vm.setStatus(faqService.deleteFaq(vm.getId()));

        return vm;
    }
}
