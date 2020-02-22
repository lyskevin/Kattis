import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        while (n > 0) {
            int size1 = 0;
            int size2 = 0;
            for (int i = 0; i < n; i++) {
                String command = fio.next();
                int numberOfPlates = fio.nextInt();
                if (command.equals("DROP")) {
                    size2 += numberOfPlates;
                    fio.println("DROP 2 " + numberOfPlates);
                } else {
                    if (size1 == 0) {
                        fio.println("MOVE 2->1 " + size2);
                        size1 = size2;
                        size2 = 0;
                        fio.println("TAKE 1 " + numberOfPlates);
                        size1 -= numberOfPlates;
                    } else if (size1 < numberOfPlates) {
                        fio.println("TAKE 1 " + size1);
                        fio.println("MOVE 2->1 " + size2);
                        int numberOfPlatesLeft = numberOfPlates - size1;
                        size1 = size2;
                        size2 = 0;
                        fio.println("TAKE 1 " + numberOfPlatesLeft);
                        size1 -= numberOfPlatesLeft;
                    } else {
                        fio.println("TAKE 1 " + numberOfPlates);
                        size1 -= numberOfPlates;
                    }
                }
            }
            n = fio.nextInt();
            if (n > 0) {
                fio.println();
            }
        }
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

