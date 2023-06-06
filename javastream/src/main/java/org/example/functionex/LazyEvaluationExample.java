package org.example.functionex;

import java.util.function.Supplier;

public class LazyEvaluationExample {

    /*
     * Lambda의 계산은 그 결과 값이 필요할 때가 되어서야 계산된다.
     * 이를 이용하여 불필요한 계산을 줄이거나 해당 코드의 실행 순서를 의도적으로 미룰 수 있다.
     * */


    public static boolean returnTrue() {
        System.out.println("returnTrue() 호출");
        return true;
    }

    public static boolean returnFalse() {
        System.out.println("returnFalse() 호출");
        return false;
    }

    public static boolean or(boolean x, boolean y) {
        return x || y;
    }

    public static boolean orLazy(Supplier<Boolean> x, Supplier<Boolean> y) {
        return x.get() || y.get();
    }
}
