import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int p = sc.nextInt();
            int l = sc.nextInt();
            int e = sc.nextInt();
            int r = sc.nextInt();
            int s = sc.nextInt();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int temp = m;
                m = p / s;
                p = l / r;
                l = temp * e;
            }
            System.out.println(m);
        }

    }
}

