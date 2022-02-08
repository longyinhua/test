package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping(value={"/login"})
    public String loginPage(){

        //跳转到登录页面 login.html
        return "login";
    }
}
