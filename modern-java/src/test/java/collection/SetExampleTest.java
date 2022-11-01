package collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Test;

class SetExampleTest {

    @Test
    void test() {
        Set<String> stringSet = new HashSet<>();

        stringSet.add("123");
        stringSet.add("123");

        System.out.println(stringSet.size());
    }

    @Test
    void test1() {
        Set<String> stringSet = new HashSet<>();

        String a = new String("123");
        String a1 = new String("123");

        stringSet.add(a);
        stringSet.add(a1);

        System.out.println(a == a1);
        System.out.println(a.equals(a1));
        System.out.println(stringSet.size());
    }

    @Test
    void test2() {
        Set<Node> nodeSet = new HashSet<>();

        Node node1 = new Node(1);
        Node node2 = new Node(1);

        nodeSet.add(node1);
        nodeSet.add(node2);

        System.out.println(node1 == node2);
        System.out.println(node1.equals(node2));
        System.out.println(nodeSet.size());
    }

    @Test
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