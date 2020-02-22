import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.HashSet;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        long number = fr.nextLong();
        if (number == 1) {
            System.out.println(0);
            return;
        }
        long primeFactor = 2;
        long sqrt = (long) Math.sqrt(number);
        PriorityQueue<Long> primeFactors = new PriorityQueue<>();
        while (number >= 1 && primeFactor <= sqrt) {
            if (number % primeFactor == 0) {
                number /= primeFactor;
                primeFactors.offer(primeFactor);
                System.out.println(primeFactor);
            } else {
                primeFactor++;
            }
        }
        System.out.println(primeFactors.size());
        HashSet<Long> factors = new HashSet<>();
        int numberOfPoints = 0;
        long currentFactor = 1;
        while (!primeFactors.isEmpty()) {
            currentFactor *= primeFactors.poll();
            if (!factors.contains(currentFactor)) {
                factors.add(currentFactor);
                currentFactor = 1;
                numberOfPoints++;
            }
        }
        if (numberOfPoints == 0) {
            System.out.println(1);
        } else {
            System.out.println(numberOfPoints);
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

