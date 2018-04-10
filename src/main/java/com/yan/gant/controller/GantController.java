package com.yan.gant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class GantController {

    @RequestMapping("/index")
    public String index(){
        return "demo";
    }
}