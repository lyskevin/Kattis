import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.Stack;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfPairs = fr.nextInt();
        Stack<Integer> originalPile = new Stack<>();
        Stack<Integer> auxiliaryPile = new Stack<>();
        for (int i = 0, n = numberOfPairs * 2; i < n; i++) {
            originalPile.push(fr.nextInt());
        }
        int numberOfMoves = 0;
        while (!originalPile.isEmpty()) {
            if (auxiliaryPile.isEmpty()
                || !originalPile.peek().equals(auxiliaryPile.peek())) {
                auxiliaryPile.push(originalPile.pop());
            } else {
                originalPile.pop();
                auxiliaryPile.pop();
            }
            numberOfMoves++;
        }
        if (auxiliaryPile.isEmpty()) {
            System.out.println(numberOfMoves);
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

