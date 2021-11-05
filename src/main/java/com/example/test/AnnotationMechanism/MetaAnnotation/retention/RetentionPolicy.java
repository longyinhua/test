package com.example.test.AnnotationMechanism.MetaAnnotation.retention;

/**
 * Reteniton注解的作用是：描述注解保留的时间范围（即：被描述的注解在它所修饰的类中可以被保留到何时） 。
 */
public enum RetentionPolicy {

    SOURCE,  //源文件保留
    CLASS,   //编译期保留，默认值
    RUNTIME  //运行期保留，可通过反射去获取注解信息


}
