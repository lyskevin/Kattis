import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfRows = fr.nextInt();
        int numberOfColumns = fr.nextInt();
        //fr.nextLine();
        String[] danceMoves = new String[numberOfRows];
        for (int i = 0; i < numberOfRows; i++) {
            danceMoves[i] = fr.nextLine();
        }
        int numberOfDanceMoves = 1;
        for (int j = 0; j < numberOfColumns; j++) {
            boolean isBlankColumn = true;
            for (int k = 0; k < numberOfRows; k++) {
                if (danceMoves[k].charAt(j) == '$') {
                    isBlankColumn = false;
                }
            }
            if (isBlankColumn) {
                numberOfDanceMoves++;
            }
        }
        System.out.println(numberOfDanceMoves);
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

