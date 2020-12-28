import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        HashSet<String> employees = new HashSet<>();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            String action = fio.next();
            String name = fio.next();
            boolean isAnomaly = false;            

            fio.print(name);
            if (action.equals("entry")) {
                if (employees.contains(name)) {
                    isAnomaly = true;
                }
                employees.add(name);
                fio.print(" entered");
            } else {
                if (!employees.contains(name)) {
                    isAnomaly = true;
                }
                employees.remove(name);
                fio.print(" exited");
            }
            
            if (isAnomaly) {
                fio.println(" (ANOMALY) ");
            } else {
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

