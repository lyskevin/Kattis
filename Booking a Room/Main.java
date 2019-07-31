import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] bookedRooms = new boolean[100];
        int numberOfRooms = sc.nextInt();
        int numberOfBookedRooms = sc.nextInt();
        if (numberOfBookedRooms == numberOfRooms) {
            System.out.println("too late");
        } else {
            for (int i = 0; i < numberOfBookedRooms; i++) {
                int bookedRoom = sc.nextInt();
                bookedRooms[bookedRoom - 1] = true;
            }
            for (int i = 0; i < 100; i++) {
                if (!bookedRooms[i]) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}
