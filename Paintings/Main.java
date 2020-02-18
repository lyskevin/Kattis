import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static String[] painting;
    private static int count;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            painting = null;
            int n = fio.nextInt();
            String[] colors = new String[n];
            HashMap<String, HashSet<String>> hideousPairings = new HashMap<>();
            for (int j = 0; j < n; j++) {
                colors[j] = fio.next();
            }
            int m = fio.nextInt();
            // Store hideous pairings
            for (int j = 0; j < m; j++) {
                String color1 = fio.next();
                String color2 = fio.next();
                if (!hideousPairings.containsKey(color1)) {
                    HashSet<String> pairing = new HashSet<>();
                    hideousPairings.put(color1, pairing);
                }
                HashSet<String> pairing = hideousPairings.get(color1);
                pairing.add(color2);
                hideousPairings.put(color1, pairing);
                if (!hideousPairings.containsKey(color2)) {
                    pairing = new HashSet<>();
                    hideousPairings.put(color2, pairing);
                }
                pairing = hideousPairings.get(color2);
                pairing.add(color1);
                hideousPairings.put(color2, pairing);
            }
            String[] bestPainting = new String[n];
            count = 0;
            boolean[] usedColors = new boolean[n];
            // Generate all possible paintings
            generatePaintings(colors, hideousPairings, usedColors, bestPainting, 0);
            fio.println(count);
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    fio.print(" ");
                }
                fio.print(painting[j]);
            }
            fio.println();
        }
        fio.close();
    }

    private static void generatePaintings(String[] colors, HashMap<String, HashSet<String>> hideousPairings,
            boolean[] usedColors, String[] bestPainting, int bestPaintingIndex) {
        // Most preferred painting reached first
        if (bestPaintingIndex == bestPainting.length) {
            if (painting == null) {
                painting = new String[bestPainting.length];
                for (int i = 0; i < bestPainting.length; i++) {
                    painting[i] = bestPainting[i];
                }
            }
            count++;
        } else {
            for (int i = 0; i < colors.length; i++) {
                String color = colors[i];
                // Cannot use current color
                if (bestPaintingIndex > 0 && hideousPairings.containsKey(bestPainting[bestPaintingIndex - 1])
                        && hideousPairings.get(bestPainting[bestPaintingIndex - 1]).contains(color)) {
                    continue;
                }
                // Current color already used
                if (usedColors[i]) {
                    continue;
                }
                bestPainting[bestPaintingIndex] = color;
                usedColors[i] = true;
                generatePaintings(colors, hideousPairings, usedColors, bestPainting, bestPaintingIndex + 1);
                usedColors[i] = false;
            }
        }
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

