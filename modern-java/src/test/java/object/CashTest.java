package object;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CashTest {

    @Test
    void testMock() {
        Exchange exchange = Mockito.mock(Exchange.class);
        Mockito.doReturn(1234)
                .when(exchange)
                .rate("USD", "EUR");

        Cash dollar = new Cash(exchange, 500);
        Cash euro = dollar.in("EUR");

        assertThat(500*1234).isEqualTo(euro.getCents());
    }

    @Test
    void testFake() {
        Exchange exchange = new FakeExchange();
        Cash dollar = new Cash(exchange, 500);
        Cash euro = dollar.in("EUR");

        assertThat(500*1234).isEqualTo(euro.getCents());
    }
}
