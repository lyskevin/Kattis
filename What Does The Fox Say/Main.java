import java.util.Scanner;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numberOfTestCases; i++) {
            String[] sounds = sc.nextLine().split(" ");
            boolean[] isOtherAnimalSound = new boolean[sounds.length];
            String input = sc.nextLine();
            while (!input.equals("what does the fox say?")) {
                String sound = input.split(" ")[2];
                for (int j = 0; j < sounds.length; j++) {
                    if (sounds[j].equals(sound)) {
                        isOtherAnimalSound[j] = true;
                    }
                }
                input = sc.nextLine();
            }
            boolean isFirstFoxSound = true;
            for (int k = 0; k < sounds.length; k++) {
                if (!isOtherAnimalSound[k]) {
                    if (isFirstFoxSound) {
                        isFirstFoxSound = false;
                    } else {
                        System.out.print(" ");
                    }
                    System.out.print(sounds[k]);
                }
            }
            System.out.println();
        }
    }
}
