package defaultMethod.diamond;

public class F implements A, A2 {

    @Override
    public void hello() {
        A.super.hello();
    }
}
