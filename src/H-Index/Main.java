import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> researchPaperCitations = new ArrayList<>();
        int numberOfResearchPapers = sc.nextInt();
        for (int i = 0; i < numberOfResearchPapers; i++) {
            int numberOfCitations = sc.nextInt();
            researchPaperCitations.add(numberOfCitations);
        }
        Collections.sort(researchPaperCitations);
        int hIndex = 0;
        for (int i = 0; i < numberOfResearchPapers; i++) {
            int numberOfCitations = researchPaperCitations.get(i);
            int numberOfResearchPapersRemaining = numberOfResearchPapers - i;
            if (hIndex < numberOfResearchPapersRemaining) {
                hIndex = numberOfResearchPapersRemaining;
            }
            if (numberOfCitations <= numberOfResearchPapers - i) {
                hIndex = numberOfCitations;
            } else {
                break;
            }
        }
        System.out.println(hIndex);
    }
}

