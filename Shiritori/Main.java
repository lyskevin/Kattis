import java.util.HashSet;
import java.util.Scanner;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfWords = sc.nextInt();
        HashSet<String> usedWords = new HashSet<>();
        String previousWord = sc.next();
        usedWords.add(previousWord);
        for (int i = 0, n = numberOfWords - 1; i < n; i++) {
            String word = sc.next();
            if (word.charAt(0) != previousWord.charAt(previousWord.length() - 1)
                || usedWords.contains(word)) {
                if (i % 2 == 0) {
                    System.out.println("Player 2 lost");
                } else {
                    System.out.println("Player 1 lost");
                }
                return;
            } else {
                usedWords.add(word);
                previousWord = word;
            }
        }
        System.out.println("Fair Game");
    }
}
