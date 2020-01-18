import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int count1 = fio.nextInt();
        boolean[] movieList1 = new boolean[1000000];
        for (int i = 0; i < count1; i++) {
            movieList1[fio.nextInt()] = true;
        }
        int count2 = fio.nextInt();
        boolean[] movieList2 = new boolean[1000000];
        for (int i = 0; i < count2; i++) {
            movieList2[fio.nextInt()] = true;
        }
        boolean firstPersonTurn = true;
        boolean secondPersonTurn = true;
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            if (movieList1[i] && movieList2[i]) {
                count++;
                // Both people can like the next movie
                firstPersonTurn = true;
                secondPersonTurn = true;
            } else if (firstPersonTurn && movieList1[i]) {
                // The second person must like the next movie
                firstPersonTurn = false;
                secondPersonTurn = true;
                count++;
            } else if (secondPersonTurn && movieList2[i]) {
                // The first person must like the next movie
                firstPersonTurn = true;
                secondPersonTurn = false;
                count++;
            }
        }
        fio.println(count);
        fio.close();
    }
}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
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

