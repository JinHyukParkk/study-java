package lambda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumberObject {
    private int number;

    public NumberObject(int number) {
        this.number = number;
    }
}
