package object;

public class Cash {

    private final Exchange exchange;
    private final int cents;

    public Cash(Exchange exchange, int cents) {
        this.exchange = exchange;
        this.cents = cents;
    }

    public Cash in(String currency) {
        return new Cash(
                this.exchange,
                this.cents  * this.exchange.rate(
                        "USD", currency)
                );
    }

    public Exchange getExchange() {
        return exchange;
    }

    public int getCents() {
        return cents;
    }
}
