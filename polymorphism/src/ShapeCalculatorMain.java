import java.util.ArrayList;
import java.util.List;

public class ShapeCalculatorMain {
    public static void main(String[] args) {
        Shape cir = new Circle(2);
        Shape rec = new Rectangle(4,3);
        Shape triangle = new Triangle(3,3,3);
        Rectangle rect = new Rectangle();
        rect.setDimensions(10,15);

        Rectangle square = new Rectangle();
        square.setDimensions(10,10);


        List<Shape> shapes= new ArrayList<>();
        shapes.add(cir);
        shapes.add(rec);
        shapes.add(triangle);
        shapes.add(rect);
        shapes.add(square);

        //Loop through list and print the Perimeter and Area of the shapes.
        for(Shape sh:shapes){
            System.out.println("Perimeter is " + sh.calculatePerimeter());
            System.out.println("Area is " + sh.calculateArea());
        }

    }
}
