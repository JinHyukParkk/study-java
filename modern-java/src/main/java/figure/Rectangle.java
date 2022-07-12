package figure;

public class Rectangle extends Figure {

    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return 0;
    }

    public void print() {
        System.out.println("직사각형입니다.");
    }
}
