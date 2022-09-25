package object;

public class FakeExchange implements Exchange{

    @Override
    public int rate(String usd, String currency) {
        return 1234;
    }
}
