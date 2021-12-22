package lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class lambdaExpressionTest {
    /*
    (매개변수목록) -> {함수몸체}
    1. 매개변수의 타입을 추론할 수 있는 경우에는 타입을 생략
    2. 매개변수가 하나인 경우에는 괄호 생략 가능
    3. 함수의 몸체가 하나의 명령문만으로 이루어진 경우에는 중괄호{} 샐략
    4. 함수의 몸체가 하나의 return 문으로만 이루어진 경우에는 중괄호 생략 불가
    5. return 문 대신 표현식을 사용할 수 있으며, 이 때 반환값을 표현식의 결괏값이 됨
     */
    //

    @Test
    @DisplayName("람다 표현식")
    void expression() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("전통적인 방식의 일회용 스레드 생성");
            }
        }).start();

        new Thread(() -> {
            System.out.println("람다 표현식을 사용한 일회용 스레드 생성");
        }).start();
    }

    @Test
    @DisplayName("함수형 인터페이스 사용")
    void functionInterface() {
        // 추상 메소드의 구현
        Calc minNum = (x, y) -> x < y ? x: y;

        // 함수형 인터페이스의 사용
        System.out.println(minNum.min(3, 4));
    }

    @Test
    @DisplayName("메소드 참조")
    void methodReference() {
        DoubleUnaryOperator operator;

        operator = (n) -> Math.abs(n);
        System.out.println(operator.applyAsDouble(-5));

        operator = Math::abs;
        System.out.println(operator.applyAsDouble(-5));
    }

    @Test
    @DisplayName("생성자 참조")
    void constructorReference() {
        Function<Integer, NumberObject> function1 = a -> new NumberObject(a);
        Function<Integer, NumberObject> function2 = NumberObject::new;

        NumberObject numberObject = function1.apply(1);

        System.out.println(numberObject.toString());
    }
}
