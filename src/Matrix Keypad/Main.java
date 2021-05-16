import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int T = fio.nextInt();

        for (int i = 0; i < T; i++) {
            int r = fio.nextInt();
            int c = fio.nextInt();
            char[][] grid = new char[r][c];
            char[][] result = new char[r][c];

            for (int j = 0; j < r; j++) {
                String row = fio.nextLine();
                for (int k = 0; k < c; k++) {
                    grid[j][k] = row.charAt(k);
                    result[j][k] = 'N';
                }
            }

            boolean isPossible = true;
            HashSet<Integer> rows = new HashSet<>();
            HashSet<Integer> cols = new HashSet<>();

            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (grid[j][k] == '1') {
                        rows.add(j);
                        cols.add(k);
                    }
                }
            }

            for (int j = 0; j < r && isPossible; j++) {
                for (int k = 0; k < c && isPossible; k++) {
                    if (rows.contains(j) && cols.contains(k)) {
                        if (grid[j][k] == '0') {
                            isPossible = false;
                        } else if (rows.size() == 1 || cols.size() == 1) {
                            result[j][k] = 'P';
                        } else {
                            result[j][k] = 'I';
                        }
                    }
                }
            }
            
            if (isPossible) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        fio.print(result[j][k]);
                    }
                    fio.println();
                }
            } else {
                fio.println("impossible");
            }

            fio.println("----------");
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

