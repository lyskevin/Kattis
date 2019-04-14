import java.util.*;
public class Pot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            x += (long) Math.pow(num / 10, num % 10);
        }
        System.out.println(x);
    }
}
