package com.example.test.thread;

import com.example.test.userInfo.model.Userinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadUtils<T> {
    private static Logger logger = LoggerFactory.getLogger(MultiThreadUtils.class);
    /**
     * 总结果集
     */
    List<ResultBean<Userinfo>> result = new ArrayList<>();

    /**
     * 线程个数，如果没有赋值，则默认为5
     */
    private int threadCount = 20;

    /**
     * 线程池管理器
     */
    private CompletionService<ResultBean> pool = null;

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public static MultiThreadUtils newInstance(int threadCount) {
        MultiThreadUtils instance = new MultiThreadUtils();
        threadCount = threadCount;
        instance.setThreadCount(threadCount);
        return instance;
    }

    @SuppressWarnings("rawtypes")
    public ResultBean execute(List<T> data, ITask<ResultBean<Userinfo>, T> task) {
        // 创建线程池
        ExecutorService threadpool = Executors.newFixedThreadPool(threadCount);
        // 根据线程池初始化线程池管理器
        pool = new ExecutorCompletionService<ResultBean>(threadpool);
        // 开始时间（ms）
        long l = System.currentTimeMillis();
        // 数据量大小
        int length = data.size();
        // 每个线程处理的数据个数
        int taskCount = length / threadCount;
        // 划分美俄线程调用的数据
        for (int i = 0; i < threadCount; i++) {
            //每个线程任务数据list
            List<T> subData = null;
            if (i == (threadCount - 1)) {
                subData = data.subList(i * taskCount, length);
            } else {
                subData = data.subList(i * taskCount, (i + 1) * taskCount);
            }
            // 将数据分配给各个线程
            HandleCallable eCallable = new HandleCallable<T>(String.valueOf(i), subData, task);
            // 将线程加入到线程池
            pool.submit(eCallable);//提交任务
        }
        for (int i = 0; i < threadCount; i++) {
            // 每个线程处理结果集
            ResultBean<List<ResultBean<Userinfo>>> threadResult;
            try {
                threadResult = pool.take().get();
                result.addAll(threadResult.getData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();

            }
        }
        // 关闭线程池
        threadpool.shutdownNow();
        // 执行结束时间
        long end_time = System.currentTimeMillis();
        logger.info("总耗时：{}ms",(end_time - l));
        logger.info("========================结果集=====================:{}",result.size());
        return ResultBean.newInstance().setData(result);
    }


}
