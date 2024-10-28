package HW;

import java.util.Scanner;

public class Laba_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the coordinates of the points, each on a separate line");

        Point3d point1 = new Point3d(sc.nextInt(), sc.nextInt(), sc.nextInt());
        Point3d point2 = new Point3d(sc.nextInt(), sc.nextInt(), sc.nextInt());
        Point3d point3 = new Point3d(sc.nextInt(), sc.nextInt(), sc.nextInt());

        if (point1.equals(point2) || point1.equals(point3) || point2.equals(point3)) {
            System.out.println("The points are equal, there is no triangle");
        } else {
            System.out.printf("Square = %.2f", computreArea(point1, point2, point3));
        }

    }

    public static double computreArea(Point3d p1, Point3d p2, Point3d p3) {
        double edge1 = p1.distanceTo(p2);
        double edge2 = p2.distanceTo(p3);
        double edge3 = p3.distanceTo(p1);

        double semiP = (edge1 + edge2 + edge3) / 2;

        double square = Math.sqrt(semiP * (semiP - edge1) * (semiP - edge2) * (semiP - edge3));
        return square;
    }

}
