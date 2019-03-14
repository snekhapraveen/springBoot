package com.example.demo.utils;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

//These values can be added at the time of creating this annotation
@Retention(RUNTIME)
@Target(METHOD)//Because only method can have execution time

public @interface ShowExecutionTime {

}
