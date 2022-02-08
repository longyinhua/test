package com.example.test.thread;

import com.example.test.userInfo.model.Userinfo;
import com.example.test.userInfo.service.UserinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Running implements ApplicationRunner, ITask<ResultBean<Userinfo>, Userinfo> {
    private static final Logger log = LoggerFactory.getLogger(Running.class);

    private UserinfoService userinfoService;

    public Running() {
        this.userinfoService = ApplicationContextProvider.getBean(UserinfoService.class);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Userinfo> data = new ArrayList<>();
        int selectCount = 2000;
        for (int i = 1; i <= 1; i++) {
            log.info("~~~~~~~~~~~~~~~~~~~~~~~第" + i + "次数据开始执行~~~~~~~~~~~~~~~~~~~~~");
//            if (i == 1) {
            int size = 100;
            for (int h = 1; h <= size; h++) {
                Userinfo s = new Userinfo();
                s.setId(10 + h);
                s.setUserName("張三" + h);
                s.setPassword("11" + h);
                data.add(s);
            }
//            }
            // 创建多线程处理任务
            MultiThreadUtils<Userinfo> threadUtils = MultiThreadUtils.newInstance(20);
            ITask<ResultBean<Userinfo>, Userinfo> task = new Running();
            // 执行多线程处理，并返回处理结果
            threadUtils.execute(data, task);
            log.info("~~~~~~~~~~~~~~~~~~~~~~~第" + i + "次数据执行完毕~~~~~~~~~~~~~~~~~~~~~");
        }

    }


    @Override
    public ResultBean<Userinfo> execute(Userinfo userinfo) {
        ResultBean<Userinfo> resultBean = ResultBean.newInstance();
        log.info("~~~~~~~~~~~~~~~~~~~~~~~开始插入用户数据~~~~~~~~~~~~~~~~~~~~~~~");
        int b = userinfoService.insertUser(userinfo);
        if (b > 0) {
            log.info("~~~~~~~~~~~~~~~~~~~~~~~用户数据插入成功~~~~~~~~~~~~~~~~~~~~~~~");
        }
        resultBean.setData(userinfo);
        return resultBean;
    }


}
