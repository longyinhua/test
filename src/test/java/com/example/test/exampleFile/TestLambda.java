package com.example.test.exampleFile;

import com.example.test.userInfo.model.Userinfo;
import com.mysql.cj.xdevapi.Collection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//java lambda表达式检查list集合是否存在某个值
@SpringBootTest
public class TestLambda {

    @Test
    void contextLoads() {
        System.out.println("11");
    }

    public static void main(String[] args) {
        Userinfo userinfo1 =new Userinfo();
        userinfo1.setUserName("张三");
        userinfo1.setPassword("123456");
        Userinfo userinfo2 =new Userinfo();
        userinfo2.setUserName("李四");
        userinfo2.setPassword("1234563");
        List<Userinfo> list = new ArrayList();
        list.add(userinfo1);
        list.add(userinfo2);

         //判断集合list中username是否存在张三这个值，存在返回true
        boolean bool = list.stream().anyMatch(a->a.getUserName().equals("张三"));

        //过滤集合list中含有username为张三的值,结果集为过滤后的集合（全是包含张三的对象）
        List<Userinfo> data = list.stream().filter(a->a.getUserName().equals("张三"))
                            .collect(Collectors.toList());
         if(data!=null&&data.size()>0){
             for (Userinfo userinfo:data) {
                 System.out.println(userinfo.getUserName()+"------------"+userinfo.getPassword());
             }
         }
    }
}
