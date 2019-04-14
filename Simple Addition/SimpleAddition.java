import java.util.*;
import java.math.*;
public class SimpleAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger int1 = new BigInteger(sc.next());
        System.out.println(int1.add(new BigInteger(sc.next())));
    }
}
