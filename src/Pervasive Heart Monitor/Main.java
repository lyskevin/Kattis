import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        while (true) {
            try {
                String s = fio.nextLine();
                String[] details = s.split(" ");
                ArrayList<String> patients = new ArrayList<>();
                int count = 0;
                double total = 0.0;

                for (int i = 0; i < details.length; i++) {
                    if (details[i].charAt(0) >= '0' && details[i].charAt(0) <= '9') {
                        count++;
                        total += Double.parseDouble(details[i]);
                    } else {
                        patients.add(details[i]);
                    }
                }

                fio.print(total / count);
                
                for (String patient : patients) {
                    fio.print(" ");
                    fio.print(patient);
                }

                fio.println();
            } catch (NullPointerException e) {
                break;
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

