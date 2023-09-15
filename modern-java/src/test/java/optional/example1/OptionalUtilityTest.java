package optional.example1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class OptionalUtilityTest {

    @Test
    void case1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("test", 1);

        System.out.println(Optional.ofNullable(map.getOrDefault("A", null)).orElse(1));
    }

    @Test
    void case2() {
        // 예제로 사용할 문자열
        String nullableString = "Hello, World!";

        // 문자열을 Optional로 감싸기
//        Optional<String> optionalString = Optional.ofNullable(nullableString);
        Optional<String> optionalString = Optional.of(nullableString);

        // 문자열이 존재하는 경우 출력
        optionalString.ifPresent(str -> {
            System.out.println("문자열이 존재합니다: " + str);
        });

        // 문자열이 없는 경우 기본값으로 대체
        String result = optionalString.orElse("기본값");
        System.out.println("결과: " + result);

        // 문자열이 있는 경우 특정 조건에 따라 추가 작업 수행
        optionalString.filter(str -> str.contains("Hello")).ifPresent(str -> {
            System.out.println("Hello를 포함하는 문자열입니다: " + str);
        });

        // 문자열을 대문자로 변환
        optionalString.map(String::toUpperCase).ifPresent(upperCaseStr -> {
            System.out.println("대문자로 변환된 문자열: " + upperCaseStr);
        });
    }
}
