package chapter4.item23;

import java.util.List;

abstract class Figure2 {
    abstract double area();
}

class Circle extends Figure2 {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}

class Rectangle extends Figure2 {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

class Figure3 {

    private final Figure figure;

    Figure3(Figure figure) {
        this.figure = figure;
    }
}

class Triangle {

    Figure figure;

//    void run() {
//        figure.radius ...
//    }
}
