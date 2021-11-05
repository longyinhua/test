package com.example.test.AnnotationMechanism.MetaAnnotation;

/**
 * Target注解的作用是：描述注解的使用范围（即：被修饰的注解可以用在什么地方） 。
 */
public enum ElementType {
    TYPE,//类、接口、枚举类

    FIELD,//成员变量（包括：枚举常量）

    METHOD,//成员方法

    PARAMETER,//方法参数

    CONSTRUCTOR,//构造方法

    LOCAL_VARIABLE,//局部变量

    ANNOTATION_TYPE,//注解类

    PACKAGE,//可用于修饰：包

    TYPE_PARAMETER,//类型参数，JDK 1.8 新增

    TYPE_USE //使用类型的任何地方，JDK 1.8 新增
}
