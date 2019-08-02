import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfChildren = sc.nextInt();
        int numberOfCommands = sc.nextInt();
        sc.nextLine();
        String[] commands = sc.nextLine().split(" ");
        ArrayList<Integer> eggPositions = new ArrayList<>();
        eggPositions.add(0);
        int positionIndex = 0;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (command.equals("undo")) {
                positionIndex -= Integer.parseInt(commands[i + 1]);
                i++;
            } else {
                int distance = Integer.parseInt(commands[i]);
                int previousPosition = eggPositions.get(positionIndex);
                int currentPosition = previousPosition
                    + (distance % numberOfChildren);
                if (currentPosition < 0) {
                    currentPosition += numberOfChildren;  
                } else if (currentPosition >= numberOfChildren) {
                    currentPosition -= numberOfChildren;
                }
                if (positionIndex == eggPositions.size() - 1) {
                    eggPositions.add(currentPosition);
                } else {
                    eggPositions.set(positionIndex + 1, currentPosition);
                }
                positionIndex++;
            }
        }
        System.out.println(eggPositions.get(positionIndex));
    }
}

