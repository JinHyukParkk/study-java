package collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SetExampleTest {

    @Test
    @DisplayName("같은 문자열 선언 Set에 넣을 때")
    void test() {
        Set<String> stringSet = new HashSet<>();

        stringSet.add("123");
        stringSet.add("123");

        // 같은 문자열일 경우 String constants pool에 저장된 값이기 때문에 주소 값이 같다.
        System.out.println(stringSet.size());
    }

    @Test
    @DisplayName("new String 객체 Set에 넣을 때")
    void test1() {
        Set<String> stringSet = new HashSet<>();

        String a = new String("123");
        String a1 = new String("123");

        stringSet.add(a);
        stringSet.add(a1);

        // 생성된 주소값이 다르다
        System.out.println(a == a1);

        // String 클래스 안에 equals에서 내부적으로 같은 값임을 비교한다.
        System.out.println(a.equals(a1));

        System.out.println(stringSet.size());
    }

    @Test
    @DisplayName("equal(), hashCode() 재선언한 Node 객체 Set에 넣기")
    void test2() {
        Set<Node> nodeSet = new HashSet<>();

        Node node1 = new Node(1);
        Node node2 = new Node(1);

        nodeSet.add(node1);
        nodeSet.add(node2);

        // 주소 값이 다르다.
        System.out.println(node1 == node2);

        // 기존 Object의 equals에서 단순하게 주소값으로 비교하지만 값 비교로 재선언
        System.out.println(node1.equals(node2));

        // hashCode()를 값 기준으로 생성하여 같은 HashTable의 key로 들어가고 중복된 값은 equals 비교를 함
        System.out.println(nodeSet.size());
    }

    @Test
    @DisplayName("그냥 Node Set에 넣기")
    void test3() {
        Set<Node1> nodeSet = new HashSet<>();

        Node1 node1 = new Node1(1);
        Node1 node2 = new Node1(1);

        nodeSet.add(node1);
        nodeSet.add(node2);

        System.out.println(node1 == node2);
        System.out.println(node1.equals(node2));
        System.out.println(nodeSet.size());
    }

    static class Node {

        private int value = 1;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (o == null || getClass() != o.getClass()) {return false;}
            Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    static class Node1 {

        private int value = 1;

        public Node1(int value) {
            this.value = value;
        }
    }
}