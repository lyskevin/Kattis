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
                boolean degreeFound = false;
                for (int i = s.length() - 1; i >= 1; i--) {
                    HashMap<String, Integer> substringFrequencies = new HashMap<>();
                    int frequencyOneCount = 0;
                    // Count frequencies of substrings of length i
                    for (int j = 0; j < s.length() - i + 1; j++) {
                        String currentSubstring = s.substring(j, j + i);
                        if (substringFrequencies.containsKey(currentSubstring)) {
                            if (substringFrequencies.get(currentSubstring).intValue() == 1) {
                                frequencyOneCount--;
                            }
                            substringFrequencies.put(currentSubstring, substringFrequencies.get(currentSubstring) + 1);
                        } else {
                            frequencyOneCount++;
                            substringFrequencies.put(currentSubstring, 1);
                        }
                    }
                    // All substrings have a frequency > 1 ==> largest degree of self-similarity found
                    if (frequencyOneCount == 0) {
                        fio.println(i);
                        degreeFound = true;
                        break;
                    }
                }
                if (!degreeFound) {
                    fio.println(0);
                }
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

