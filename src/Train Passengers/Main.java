import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        long capacity = fr.nextInt();
        int numberOfStations = fr.nextInt();
        long numberOfPeopleOnTrain = 0;
        boolean isPossible = true;
        for (int i = 0; i < numberOfStations && isPossible; i++) {
            int numberOfLeavingPeople = fr.nextInt();
            int numberOfEnteringPeople = fr.nextInt();
            int numberOfWaitingPeople = fr.nextInt();
            numberOfPeopleOnTrain += numberOfEnteringPeople - numberOfLeavingPeople;
            if (numberOfPeopleOnTrain < 0 || numberOfPeopleOnTrain > capacity
                || (numberOfPeopleOnTrain < capacity && numberOfWaitingPeople > 0)) {
                isPossible = false;
            }
            if (i == 0 && numberOfLeavingPeople > 0) {
                isPossible = false;
            }
            if (i == numberOfStations - 1 &&
                (numberOfWaitingPeople > 0 || numberOfPeopleOnTrain > 0)) {
                isPossible = false;
            }
        }
        if (isPossible) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }
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

