package com.example.test.AnnotationMechanism.BuiltInAnnotation;

import java.util.ArrayList;
import java.util.List;

public class B  extends A{

    /**
     * 重载父类的test方法
     */
    @Override
    public void test(){

    }

    /**
     * 被弃用的方法
     */
    @Deprecated
    public void oldMethod(){

    }

    /**
     * 忽略警告
     * @return
     */
//    @SuppressWarnings("rawtypes")
    public List processList(){
        List list = new ArrayList();
        return list;
    }


}
