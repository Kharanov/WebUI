package DZ4;

public class AreaOfTriangle {
    public static double isAreaOfTriangle(double a, double b, double c) throws Exception {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new Exception("Triangle Does Not Exist");
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new Exception("a or b or c <= 0");
        }
        double p = ((a + b + c) / 2);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
