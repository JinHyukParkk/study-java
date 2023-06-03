package org.example.streamex;

public class PartitioningByExample {
    /*
     * GroupBy와 유사하지만 Funcion 대신 Predicate을 받아 true 와 false 두 key가 존재하는 Map을 리턴
     * downstream collector를 사용하지 않으면 기본적으로 List로 저장
     * downstream collector를 사용하면 downstream collector에 의해 정의된 컬렉션으로 저장
     *
     * partitioningBy(Predicate predicate, Collector downstream)
     * */
}
