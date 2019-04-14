import java.util.*;
public class AboveAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int numStudents = sc.nextInt();
            int sum = 0;
            int[] scores = new int[numStudents];
            for (int j = 0; j < numStudents; j++) {
                scores[j] = sc.nextInt();
                sum += scores[j];
            }
            double average = 1.0 * sum / numStudents;
            int numAboveAverage = 0;
            for (int k = 0; k < numStudents; k++) {
                if (scores[k] > average) {
                    numAboveAverage++;
                }
            }
            double percentageAboveAverage = 100.0 * numAboveAverage / numStudents;
            System.out.format("%.3f", percentageAboveAverage);
            System.out.println("%");
        }
    }
}
