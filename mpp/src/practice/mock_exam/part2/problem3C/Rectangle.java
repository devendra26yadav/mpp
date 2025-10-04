package practice.mock_exam.part2.problem3C;

public class Rectangle {
    private double length;
    private double width;
    private double diagonal;
    private Rectangle(double length, double width, double diagonal) {
        this.length = length;
        this.width = width;
        this.diagonal = diagonal;
    }
    public static Rectangle fromLengthAndWidth(double length, double width) {
        double diagonal = Math.sqrt(length * length + width * width);
        return new Rectangle(length, width, diagonal);
    }

    public static Rectangle fromWidthAndDiagonal(double width, double diagonal) {
        double length = Math.sqrt(diagonal * diagonal - width * width);
        return new Rectangle(length, width, diagonal);
    }

    public double computeArea() {
        return length * width;
    }
}