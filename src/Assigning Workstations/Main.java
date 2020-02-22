import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfResearchers = fr.nextInt();
        int unlockTime = fr.nextInt();
        Comparator<Researcher> researcherComparator = new Comparator<>() {
            @Override
            public int compare(Researcher researcher1, Researcher researcher2) {
                if (researcher1.arrivalTime != researcher2.arrivalTime) {
                    return (int) (researcher1.arrivalTime - researcher2.arrivalTime);
                } else {
                    return (int) (researcher1.timeSpent - researcher2.timeSpent);
                }
            }
        };
        PriorityQueue<Researcher> researcherPQ =
            new PriorityQueue<>(researcherComparator);
        for (int i = 0; i < numberOfResearchers; i++) {
            researcherPQ.add(new Researcher(fr.nextInt(), fr.nextInt()));
        }
        Comparator<Long> arrivalTimeComparator = new Comparator<>() {
            @Override
            public int compare(Long arrivalTime1, Long arrivalTime2) {
                return arrivalTime1.compareTo(arrivalTime2);
            }
        };
        PriorityQueue<Long> unlockedWorkstations =
            new PriorityQueue<>(arrivalTimeComparator);
        int numberOfUnlocks = 0;
        while (!researcherPQ.isEmpty()) {
            Researcher researcher = researcherPQ.poll();
            long arrivalTime = researcher.arrivalTime;
            long timeSpent = researcher.timeSpent;
            if (unlockedWorkstations.isEmpty()) {     
                numberOfUnlocks++;
            } else if (unlockedWorkstations.peek() > arrivalTime) {
                numberOfUnlocks++;
            } else if (unlockedWorkstations.peek() <= arrivalTime
                       && unlockedWorkstations.peek() + unlockTime >= arrivalTime) {
                unlockedWorkstations.poll();
            } else if (unlockedWorkstations.peek() + unlockTime < arrivalTime) {
                while (!unlockedWorkstations.isEmpty()) {
                    long nextAvailableTime = unlockedWorkstations.peek();
                    if (nextAvailableTime + unlockTime < arrivalTime) {
                        unlockedWorkstations.poll();
                        continue;
                    } else if (nextAvailableTime <= arrivalTime
                               && nextAvailableTime + unlockTime >= arrivalTime) {
                        unlockedWorkstations.poll();
                        break;
                    } else if (nextAvailableTime > arrivalTime) {
                        numberOfUnlocks++;
                        break;
                    }
                }
                if (unlockedWorkstations.isEmpty()) {
                    numberOfUnlocks++;
                }
            }
            unlockedWorkstations.offer(arrivalTime + timeSpent);
        }
        System.out.println(numberOfResearchers - numberOfUnlocks);
    }
}

class Researcher {
    
    long arrivalTime;
    long timeSpent;

    Researcher(long arrivalTime, long timeSpent) {
        this.arrivalTime = arrivalTime;
        this.timeSpent = timeSpent;
    }

}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
        br = new BufferedReader(new
                InputStreamReader(System.in)); 
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}

