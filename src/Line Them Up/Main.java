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
        int numberOfPlayers = fr.nextInt();
        boolean isNeither = false;
        String previousName = fr.next();
        int previousCompareTo = 0;
        for (int i = 0, n = numberOfPlayers - 1; i < n; i++) {
            String name = fr.next();
            int compareTo = previousName.compareTo(name);
            if (i > 0 && !isSameOrder(compareTo, previousCompareTo)) {
                isNeither = true;
                break;
            }
            previousName = name;
            previousCompareTo = compareTo;
        }
        if (isNeither) {
            System.out.println("NEITHER");
        } else if (previousCompareTo < 0) {
            System.out.println("INCREASING");
        } else {
            System.out.println("DECREASING");
        }
    }
    private static boolean isSameOrder(int a, int b) {
        return (a < 0 && b < 0) || (a > 0 && b > 0); 
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

