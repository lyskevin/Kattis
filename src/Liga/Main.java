import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            String[] input = fio.nextLine().split(" ");
            int[] information = new int[5];
            for (int j = 0; j < 5; j++) {
                if (input[j].equals("?")) {
                    information[j] = -1;
                } else {
                    information[j] = Integer.parseInt(input[j]);
                }
            }
            // Information arranged in the order of games (G), wins (W), draws (D), losses (L), points (P)
            // At least one of  G, W, D, L must be known to uniquely determine the values in each field
            // This is because each L gives 0 points
            // Can solve the problem using two nested loops given these constraints
            int g = 100;
            if (information[0] > -1) { // G is known
                g = information[0];
            }
            boolean isFound = false;
            for (int j = 0; j <= g && !isFound; j++) {
                for (int k = 0; k <= g && !isFound; k++) {
                    int w;
                    int d;
                    int l;
                    if (information[1] > -1) { // W is known
                        w = information[1];
                        d = j;
                        l = k;
                    } else if (information[2] > -1) { // D is known
                        w = j;
                        d = information[2];
                        l = k;
                    } else if (information[3] > -1) { // L is known
                        w = j;
                        d = k;
                        l = information[3];
                    } else {
                        w = j;
                        d = k;
                        l = g - j - k;
                    }
                    if (w + d + l > 100 || l < 0) {
                        continue;
                    }

                    // Additional constraint: 3W + D = P
                    int p = 3 * w + d;

                    // Validity check
                    if (!((information[0] > -1 && w + d + l != information[0])
                            || (information[1] > -1 && w != information[1])
                            || (information[2] > -1 && d != information[2])
                            || (information[3] > -1 && l != information[3])
                            || (information[4] > -1 && p != information[4]))) {
                        isFound = true;
                        information[0] = w + d + l;
                        information[1] = w;
                        information[2] = d;
                        information[3] = l;
                        information[4] = p;
                    }
                }
            }
            fio.println(information[0] + " " + information[1] + " " + information[2] + " "
                    + information[3] + " " + information[4]);
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

