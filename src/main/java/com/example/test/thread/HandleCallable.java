package com.example.test.thread;

import com.example.test.userInfo.model.Userinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class HandleCallable<E> implements Callable<ResultBean> {
    private static Logger logger = LoggerFactory.getLogger(HandleCallable.class);

    /**
     * 线程名称
     */
    private String threadName = "tom";
    /**
     * 需要处理的数据
     */
    private List<E> data;
    /**
     * 辅助参数
     */
    private Map<String, Object> params;
    /**
     * 具体执行任务
     */
    private ITask<ResultBean<Userinfo>, E> task;

    public HandleCallable(String threadName, List<E> data, ITask<ResultBean<Userinfo>, E> task) {
        this.threadName = threadName;
        this.data = data;
        this.task = task;
    }

    @Override
    public ResultBean call() throws Exception {
        //该线程中所有数据处理返回结果
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        String date = year + "" + (month < 10 ? "0" + month : month);
        ResultBean<List<ResultBean<Userinfo>>> resultBean = ResultBean.newInstance();
        if (data != null && data.size() > 0) {
            //返回结果集
            List<ResultBean<Userinfo>> resultList = new ArrayList<>();
            //循环处理每个数据
            String o = null;
            Userinfo b = null;
            for (int i = 0; i < data.size(); i++) {
                //需要执行的数据
                E e = data.get(i);
                //将数据执行结果加入到结果集中
                b = (Userinfo)e;
                resultList.add(task.execute(e));
            }
            logger.info("线程：{},共处理：{}个数据，处理完成....",threadName,data.size());
            resultBean.setData(resultList);
        }
        return resultBean;
    }
}
