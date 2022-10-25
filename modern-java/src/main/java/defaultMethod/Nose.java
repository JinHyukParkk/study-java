package defaultMethod;

public class Nose implements Sized {

    private int size;

    public Nose() {
    }

    public Nose(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}
