package com.admin.vermouth.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/dist")
    public String main(){return "/dist/index.html";}

    @GetMapping("/error")
    public String error(){throw new IllegalStateException();}
}