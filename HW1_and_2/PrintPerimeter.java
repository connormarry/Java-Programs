package HW1_and_2;

public class PrintPerimeter {
    public static void main(String[] args){
        double area = Double.parseDouble(args[0]);
        double side = Math.sqrt(area);
        double perimeter = side * 4;
        System.out.println("The perimeter is: " + perimeter);
    }
}
