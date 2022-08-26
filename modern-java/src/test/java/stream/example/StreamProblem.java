package stream.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stream.grammer.model.Trader;
import stream.grammer.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StreamProblem {

    List<Transaction> transactions = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Trader hyuk = new Trader("hyuk", "SungNam");
        Trader suk = new Trader("suk", "Poland");
        Trader chul = new Trader("chul", "BuSan");
        Trader min = new Trader("min", "BuSan");

        transactions.add(new Transaction(hyuk, 2020, 100));
        transactions.add(new Transaction(hyuk, 2021, 200));
        transactions.add(new Transaction(chul, 2020, 300));
        transactions.add(new Transaction(chul, 2021, 400));
        transactions.add(new Transaction(suk, 2020, 500));
        transactions.add(new Transaction(suk, 2021, 600));
        transactions.add(new Transaction(min, 2020, 700));
        transactions.add(new Transaction(min, 2021, 800));
    }

    @Test
    @DisplayName("2020년에 일어난 모든 트랜잭션을 찾아 값을 오름차순")
    void case1() {
        List<Transaction> transactionList = transactions.stream()
                .filter(t -> t.getYear() == 2020)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());

        transactionList.forEach(System.out::println);
    }

    @Test
    @DisplayName("거래자가 근무하는 모든 도시를 중복 없이 나열")
    void case2() {
        List<String> stringList = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        stringList.forEach(System.out::println);
    }

    @Test
    @DisplayName("부산에 사는 모든 거래자를 이름순으로 나열")
    void case3() {
        List<Trader> stringList = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("BuSan"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());

        stringList.forEach(System.out::println);
    }

    @Test
    @DisplayName("모든 거래자의 이름을 알파벳 순으로 정렬해서 반환")
    void case4() {
        String s = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println(s);
    }

    @Test
    @DisplayName("성남에 거래자가 있는지")
    void case5() {
        boolean b = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("SungNam"));

        System.out.println(b);
    }

    @Test
    @DisplayName("전체 트랜잭션 중 최대값을 가진 트랜잭션")
    void case6() {
        Optional<Transaction> transaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t1 : t2);

        System.out.println(transaction.get());


        Optional<Transaction> transaction1 = transactions.stream()
                .max(comparing(Transaction::getValue));

        System.out.println(transaction1.get());
    }
}
