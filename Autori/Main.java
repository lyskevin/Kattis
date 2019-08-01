import java.util.Scanner;
import java.lang.StringBuilder;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name.charAt(0));
        for (int i = 0, n = name.length(); i < n; i++) { 
            if (name.charAt(i) == '-') {
                stringBuilder.append(name.charAt(i + 1));
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
