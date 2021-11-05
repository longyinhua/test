package com.example.test.AnnotationMechanism.BuiltInAnnotation;

import java.lang.annotation.*;

/**
 * 表示代码被弃用，如果使用了被@Deprecated注解的代码则编译器将发出警告
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE})
public @interface Deprecated {
}
