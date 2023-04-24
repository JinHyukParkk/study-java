package org.example.optionalex;

public class OptionalExample {

    /*
     *
     * NPE - NullPointException
     * Null 상태인 오브젝트를 레퍼런스 할 때 발생
     * Runtime error이기 때문에 실행 전까지는 발생 여부를 알기 쉽지 않음
     * "[Null pointer를 발명한 것은] 나의 10억 불 짜리 실수 였다 - 토니 호어 (한 강연에서)
     *
     *
     * Optional.ofNullable() : null이 아닌 경우에만 Optional 객체를 생성
     * Optional.of() : null인 경우에는 NPE 발생
     * Optional.empty() : 빈 Optional 객체 생성
     * Optional.isPresent() : 값이 있는지 확인
     * Optional.get() : 값이 있으면 값을 반환, 없으면 NoSuchElementException 발생
     * Optional.orElse() : 값이 있으면 값을 반환, 없으면 인자로 넘긴 값을 반환
     * Optional.orElseGet() : 값이 있으면 값을 반환, 없으면 인자로 넘긴 Supplier를 통해 값을 반환
     * Optional.orElseThrow() : 값이 있으면 값을 반환, 없으면 인자로 넘긴 Supplier를 통해 예외를 발생
     * Optional.map() : 값이 있으면 인자로 넘긴 함수를 실행, 없으면 빈 Optional 객체 반환
     * Optional.flatMap() : 값이 있으면 인자로 넘긴 함수를 실행, 없으면 빈 Optional 객체 반환
     * Optional.filter() : 값이 있으면 인자로 넘긴 Predicate를 실행, 없으면 빈 Optional 객체 반환
     * Optional.ifPresent() : 값이 있으면 인자로 넘긴 Consumer를 실행, 없으면 아무것도 실행하지 않음
     * */
}
