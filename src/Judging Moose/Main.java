import java.util.Scanner;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int leftTines = sc.nextInt();
        int rightTines = sc.nextInt();
        if (leftTines == 0 && rightTines == 0) {
            System.out.println("Not a moose");
        } else if (leftTines == rightTines) {
            System.out.println("Even " + (2 * leftTines));
        } else {
            System.out.println("Odd " + (2 * Math.max(leftTines, rightTines)));
        }
    }
}
