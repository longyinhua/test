package com.example.test.AnnotationMechanism.MetaAnnotation.retention;

public class RetentionTest {

    @SourcePolicy
    public void sourcePolicy(){}

    @ClassPolicy
    public void classPolicy(){}

    @RuntimePolicy
    public void  runtimePolicy(){}

}
