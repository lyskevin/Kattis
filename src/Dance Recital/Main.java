import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static String[] arrangements;
    private static boolean[] takenArrangements;
    private static int[][] quickChangeTable;
    private static int minimum;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int r = fio.nextInt();
        arrangements = new String[r];
        takenArrangements = new boolean[r];
        for (int i = 0; i < r; i++) {
            arrangements[i] = fio.nextLine();
        }
        // Generate number of quick changes between all pairs of arrangements
        quickChangeTable = new int[r][r];
        for (int i = 0; i < r - 1; i++) {
            for (int j = i + 1; j < r; j++) {
                boolean[] dancers = new boolean[26];
                for (int k = 0; k < arrangements[i].length(); k++) {
                    dancers[arrangements[i].charAt(k) - 'A'] = true;
                }
                int count = 0;
                for (int k = 0; k < arrangements[j].length(); k++) {
                    if (dancers[arrangements[j].charAt(k) - 'A']) {
                        count++;
                    }
                }
                quickChangeTable[i][j] = count;
                quickChangeTable[j][i] = count;
            }
        }
        minimum = 1000000;
        generatePermutations(0, 0, -1);
        fio.println(minimum);
        fio.close();
    }

    // Find minimum number of quick changes by generating all possible permutations
    private static void generatePermutations(int changeCount, int numberOfTakenArrangements, int previousArrangementIndex) {
        if (numberOfTakenArrangements == arrangements.length) {
            minimum = Math.min(minimum, changeCount);
            return;
        }
        for (int i = 0; i < arrangements.length; i++) {
            if (!takenArrangements[i]) {
                int newCount = changeCount + countNumberOfQuickChanges(previousArrangementIndex, i);
                if (newCount < minimum) {
                    takenArrangements[i] = true;
                    generatePermutations(newCount, numberOfTakenArrangements + 1, i);
                    takenArrangements[i] = false;
                }
            }
        }
    }

    private static int countNumberOfQuickChanges(int arrangementIndex1, int arrangementIndex2) {
        if (arrangementIndex1 == -1 || arrangementIndex2 == -1) {
            return 0;
        }
        return quickChangeTable[arrangementIndex1][arrangementIndex2];
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

