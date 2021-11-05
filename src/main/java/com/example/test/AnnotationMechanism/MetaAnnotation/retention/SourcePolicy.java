package com.example.test.AnnotationMechanism.MetaAnnotation.retention;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SourcePolicy {
}
