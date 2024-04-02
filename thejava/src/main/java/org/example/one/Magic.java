package org.example.one;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  // Interface, Class, Enum
@Retention(RetentionPolicy.SOURCE)   // 컴파일 시점 단까지만 사용
public @interface Magic {

}
