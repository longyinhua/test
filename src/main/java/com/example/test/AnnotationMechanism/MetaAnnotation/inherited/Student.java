package com.example.test.AnnotationMechanism.MetaAnnotation.inherited;

import java.lang.annotation.Annotation;

public class Student extends Person {

    public  void test(){
        Class clazz = Student.class;
        Annotation[] annotations =clazz.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation.toString());
        }
    }
//    main

}
