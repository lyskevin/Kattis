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
            String s = fio.nextLine();

            ArrayList<Character> remaining = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                remaining.add(s.charAt(j));
            }

            int count = 0;
            boolean hasMatch = true;
            while (hasMatch) {
                hasMatch = false;
               
                // Pair remaining[0] with rightmost matching character, if possible
                // Remove both characters if such a pair is found
                for (int j = remaining.size() - 1; j > 0; j--) {
                    if (remaining.get(j).charValue() == remaining.get(0).charValue()) {
                        count += remaining.size() - 1 - j;
                        hasMatch = true;
                        remaining.remove(j);
                        remaining.remove(0);
                        break;
                    }
                }

                // Pair remaining[remaining.size() - 1] with leftmost matching character, if possible
                // Remove both characters if such a pair is found
                for (int j = 0; j < remaining.size() - 1; j++) {
                    if (remaining.get(j).charValue() == remaining.get(remaining.size() - 1).charValue()) {
                        count += j;
                        hasMatch = true;
                        remaining.remove(j);
                        remaining.remove(remaining.size() - 1);
                        break;
                    }
                }
            }

            if (remaining.size() <= 1) { // Palindrome if at most one character left
                fio.println(count);
            } else {
                fio.println("Impossible");
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

