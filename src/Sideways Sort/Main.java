import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        Comparator<String> comparator = (x, y) -> {
            for (int i = 0; i < x.length(); i++) {
                int compare = Character.toLowerCase(x.charAt(i)) - Character.toLowerCase(y.charAt(i));
                if (compare != 0) {
                    return compare;
                }
            }
            return 0;
        };

        int r = fio.nextInt();
        int c = fio.nextInt();
        while (r > 0 || c > 0) {
            char[][] grid = new char[r][c];

            for (int i = 0; i < r; i++) {
                String s = fio.nextLine();
                for (int j = 0; j < c; j++) {
                    grid[i][j] = s.charAt(j);
                }
            }

            String[] columns = new String[c];
            for (int i = 0; i < c; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < r; j++) {
                    sb.append(grid[j][i]);
                }
                columns[i] = sb.toString();
            }

            Arrays.sort(columns, comparator);

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    fio.print(columns[j].charAt(i));
                }
                fio.println();
            }

            r = fio.nextInt();
            c = fio.nextInt();

            if (r > 0 || c > 0) {
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

