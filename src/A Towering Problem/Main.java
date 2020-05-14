import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int[] blocks = new int[6];
    private static boolean[] usedBlocks = new boolean[6];
    private static int[] towers = new int[6];
    private static int height1;
    private static int height2;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        for (int i = 0; i < 6; i++) {
            blocks[i] = fio.nextInt();
        }
        height1 = fio.nextInt();
        height2 = fio.nextInt();
        findTowers(0);
        for (int i = 0; i < 6; i++) {
            if (i > 0) {
                fio.print(" ");
            }
            fio.print(towers[i]);
        }
        fio.println();
        fio.close();
    }

    // Generate all permutations of blocks to find the two towers
    public static boolean findTowers(int index) {
        if (index == 3 && towers[0] + towers[1] + towers[2] != height1) { // First 3 blocks do not match first tower's height
            return false;
        }
        if (index == 6) {
            if (towers[3] + towers[4] + towers[5] != height2) { // Next 3 blocks do not match second tower's height
                return false;
            }
            return true; // Two towers found
        }
        for (int i = 0; i < 6; i++) {
            if (!usedBlocks[i] && (index == 0 || index == 3 || blocks[i] < towers[index - 1])) {
                usedBlocks[i] = true;
                towers[index] = blocks[i];
                boolean result = findTowers(index + 1);
                usedBlocks[i] = false;
                if (result) {
                    return true;
                }
            }
        }
        return false;
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

