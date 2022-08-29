package stream.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stream.grammer.model.Trader;
import stream.grammer.model.Transaction;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamGroup {

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
    void withoutGroup() {
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
    }
}
