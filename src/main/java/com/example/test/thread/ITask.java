package com.example.test.thread;

import com.example.test.userInfo.model.Userinfo;

public interface ITask<T,E> {

    ResultBean<Userinfo> execute(E e);

}
