import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        fio.nextLine();
        int n = fio.nextInt();
        String input = fio.nextLine();
        if (n == 1) {
            fio.println(input);
        } else {
            String[] firstAlternative = input.split(", ");
            String[][] alternatives = new String[n][];
            alternatives[0] = firstAlternative;
            int numberOfParts = firstAlternative.length;
            for (int i = 1; i < n; i++) {
                alternatives[i] = fio.nextLine().split(", ");
            }
            ArrayList<Integer> indices = new ArrayList<>();
            int minMax = 1000;
            for (int i = 0; i < n; i++) {
                int newMinMax = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        int count = 0;
                        for (int k = 0; k < numberOfParts; k++) {
                            if (!alternatives[i][k].equals(alternatives[j][k])) {
                                count++;
                            }
                        }
                        newMinMax = Math.max(newMinMax, count);
                    }
                }
                if (minMax > newMinMax) {
                    minMax = newMinMax;
                    indices = new ArrayList<>();
                    indices.add(i);
                } else if (minMax == newMinMax) {
                    indices.add(i);
                }
            }
            for (Integer index : indices) {
                String[] alternative = alternatives[index.intValue()];
                for (int i = 0; i < alternative.length; i++) {
                    if (i > 0) {
                        fio.print(", ");
                    }
                    fio.print(alternative[i]);
                }
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

