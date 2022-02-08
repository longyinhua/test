package com.example.test.userInfo.controller;


import com.example.test.userInfo.model.Userinfo;
import com.example.test.userInfo.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyh
 * @since 2021-11-01
 */
//@RestController
//@RequestMapping("/userInfo")

@Controller
public class UserinfoController {

    public static void main(String[] args) {
        int a=4+'4';
        System.out.println(a);
    }

    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String loginIn(String userName, String password) {
        Userinfo usereinfo = userinfoService.getUser(userName, password);
       if(usereinfo!=null){
           return "success";
       }else{
           return "error";
       }
    }

    @PostMapping("/findAllUser")
    public List<Userinfo> findAllUser() {
        return userinfoService.findAllUser();
    }

}
