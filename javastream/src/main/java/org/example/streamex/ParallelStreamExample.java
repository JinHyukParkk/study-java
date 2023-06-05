package org.example.streamex;

public class ParallelStreamExample {

    /*
     * Sequential vs Parallel
     * 여러 개의 스레드를 이용하여 stream의 처리 과정을 병렬화
     * 중간 과정은 병렬 처리 되지만 순서가 있는 Stream의 경우 종결 처리 했을 때 순서가 보장되지 않음
     * 순서가 보장되어야 하는 경우에는 parallel()을 호출하기 전에 sorted()를 호출해야 함
     *
     * parallel()을 호출하면 stream의 데이터를 여러 개의 chunk로 나누고 각각의 chunk를 별도의 스레드에서 처리
     * 이 때 chunk의 크기는 시스템의 CPU 코어 수에 따라 자동으로 정해짐
     *
     * 만약 List로 collect한다면 순서는 항상 올바르게 나옴
     * Set으로 collect한다면 순서가 보장되지 않음
     *
     * 장점
     * - 굉장히 간단하게 병렬 처리를 사용할 수 있다.
     * - 속도가 비약적으로 빨라질 수 있다.(항상은 아님)
     *
     * 단점
     * - 항상 속도가 빨라지는 것은 아니다.
     * - 공통으로 사용하는 리소스가 있을 경우 잘못된 결과가 나오거나 deadlock이 발생할 수 있다.
     * - deadlock을 방지하기 위해 mutex, semaphore 등을 사용해야 하는데 이는 성능 저하를 야기할 수 있다.
     *
     * */
}
