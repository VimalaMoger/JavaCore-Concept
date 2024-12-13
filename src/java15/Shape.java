package java15;

//sealed classes to restrict the inheritance hierarchy
public sealed class Shape {     // omitted permits Circle, Square, Rectangle{
                                    //those classed defined in the same file
    private double length;
    private double width;
}

non-sealed class Circle extends Shape{
}

final class Square extends Shape{
}

sealed class Rectangle extends Shape permits Triangle{
}

non-sealed class Triangle extends Rectangle{
}

//class Oval extends Rectangle{}   //error

//class Oval extends Square{}   //error