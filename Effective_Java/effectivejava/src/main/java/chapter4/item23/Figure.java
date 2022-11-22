package chapter4.item23;

public class Figure {
    enum Shape { RECTANGLE, CIRCLE }

    // 현재 모양을 나타낸다
    final Shape shape;

    // 다음 필드들은 사각형(RECTANGLE) 일때만 사용한다
    double length;
    double width;

    // 다음 필드는 원일때만 사용한다
    double radius;

    // 원용 생성자
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형용 생성자
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }

    }


}
