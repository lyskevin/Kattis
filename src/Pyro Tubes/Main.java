import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        HashSet<Integer> tubes = new HashSet<>();
        int L = fio.nextInt();
        while (L > -1) {
            tubes.add(L);
            L = fio.nextInt();
        }

        TreeMap<Integer, Integer> results = new TreeMap<>();
        for (int tube : tubes) {
            HashSet<Integer> validTubes = new HashSet<>();
            for (int i = 0; i < 17; i++) {
                for (int j = i + 1; j < 18; j++) {
                    int mask1 = 262143 ^ (1 << i); // _0
                    int mask2 = 262143 ^ (1 << j); // 0_
                    int mask3 = 1 << i; // _1
                    int mask4 = 1 << j; // 1_
                    
                    // & for 0 bit, | for 1 bit
                    // 00
                    int test1 = (tube & mask1) & mask2;
                    if (test1 > tube && tubes.contains(test1)) {
                        validTubes.add(test1);
                    }

                    // 01
                    int test2 = (tube | mask3) & mask2;
                    if (test2 > tube && tubes.contains(test2)) {
                        validTubes.add(test2);
                    }

                    // 10
                    int test3 = (tube & mask1) | mask4;
                    if (test3 > tube && tubes.contains(test3)) {
                        validTubes.add(test3);
                    }

                    // 11
                    int test4 = (tube | mask3) | mask4;
                    if (test4 > tube && tubes.contains(test4)) {
                        validTubes.add(test4);
                    }
                }
            }
            results.put(tube, validTubes.size());
        }

        for (int tube : results.keySet()) {
            fio.println(tube + ":" + results.get(tube));
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

