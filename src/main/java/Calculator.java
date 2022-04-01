import java.util.Objects;


public class Calculator {
    public static int adder(int a, int b) {
        return a+b;
    }

    public static int subtract(int a, int b){
        return a-b;
    }

    public static boolean isTrue(String a, String b) {
        return Objects.equals(a, b);
    }

    public static double pow(double x, double y) {
        return Math.pow(x,y);
    }
    }

