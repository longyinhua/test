package com.example.test.AnnotationMechanism.MetaAnnotation.customAnnotation;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestMethodAnnotation {

    @Override
    @MyMethodAnnotation(title = "toStringMethod", description = "override toString method")
    public String toString() {
        return "Override toString method";
    }

    @Deprecated
    @MyMethodAnnotation(title = "old static method", description = "deprecated old static method")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }


    @SuppressWarnings({"unchecked","deprecation"})
    @MyMethodAnnotation(title = "test method" ,description = "suppress warning static method")
    public static void genericsTest() throws FileNotFoundException{
        List l = new ArrayList();
        l.add("abc");
        oldMethod();

    }

    public static void main(String[] args){
      
       /* try{
            //获取所有methods
            Method[] methods = TestMethodAnnotation.class.getClassLoader()
                    .loadClass(("com.example.test.AnnotationMechanism.MetaAnnotation.customAnnotation.TestMethodAnnotation"))
                    .getMethods();

           //遍历
            for(Method method:methods){

            }

        }catch(){}*/
    }

}
