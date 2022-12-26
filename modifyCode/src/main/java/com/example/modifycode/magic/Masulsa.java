package com.example.modifycode.magic;

public class Masulsa {

    public static void main(String[] args) {
//        try {
//            new ByteBuddy().redefine(Moja.class)
//                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
//                    .make().saveIn(new File(
//                            "/Users/hyuk/Desktop/workspaces/study-java/modifyCode/build/classes/java/main/"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(new Moja().pullOut());
    }

}
