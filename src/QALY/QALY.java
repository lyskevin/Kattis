import java.util.*;
public class QALY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextDouble() * sc.nextDouble();
        }
        System.out.format("%.3f\n", sum);
    }
}
