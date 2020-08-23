package com.admin.vermouth.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView main(HttpSession session){
        ModelAndView mv = new ModelAndView("/dist/index.html");

        mv.addObject("jwt_key",session.getAttribute("jwt_key"));
        mv.addObject("jwt_token",session.getAttribute("jwt_token"));

        return mv;
    }

    @GetMapping("/error")
    public String error(){throw new IllegalStateException();}
}