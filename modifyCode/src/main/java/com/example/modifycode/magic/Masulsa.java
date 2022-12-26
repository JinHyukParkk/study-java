package com.example.modifycode.magic;

import static net.bytebuddy.matcher.ElementMatchers.named;

import java.io.File;
import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

public class Masulsa {

    public static void main(String[] args) {
        ClassLoader classLoader = Masulsa.class.getClassLoader();
        TypePool typePool = TypePool.Default.of(classLoader);

        try {
            new ByteBuddy().redefine(
                            typePool.describe("com/example/modifycode/magic/Moja").resolve(),
                            ClassFileLocator.ForClassLoader.of(classLoader))
                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                    .make().saveIn(new File(
                            "/Users/hyuk/Desktop/workspaces/study-java/modifyCode/build/classes/java/main/"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(new Moja().pullOut());
    }

}
