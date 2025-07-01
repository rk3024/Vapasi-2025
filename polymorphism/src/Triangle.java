public class Triangle extends Shape{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        return this.side1 * this.side2 * this.side3;
    }

    @Override
    public double calculatePerimeter() {
        return this.side1 + this.side2 + this.side3;
    }
}
