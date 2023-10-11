package defaultMethod.diamond;

public class F implements A, A2 {

    @Override
    public void hello() {
        A.super.hello();
    }

    public void hello2() {
        A2.super.hello();
    }
}
