import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        String input = fio.nextLine();
        DecimalFormat df = new DecimalFormat("0.00");
        while (!input.equals("0")) {
            String[] arguments = input.split(" ");
            int f = Integer.parseInt(arguments[0]);
            int r = Integer.parseInt(arguments[1]);
            int[] frontTeeth = new int[f];
            for (int i = 0; i < f; i++) {
                frontTeeth[i] = fio.nextInt();
            }
            int[] rearTeeth = new int[r];
            for (int i = 0; i < r; i++) {
                rearTeeth[i] = fio.nextInt();
            }
            ArrayList<Double> driveRatios = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < f; j++) {
                    driveRatios.add(1.0 * rearTeeth[i] / frontTeeth[j]);
                }
            }
            Collections.sort(driveRatios);
            double maxSpread = 0.0;
            for (int i = 0; i < driveRatios.size() - 1; i++) {
                maxSpread = Math.max(maxSpread, driveRatios.get(i + 1) / driveRatios.get(i));
            }
            fio.println(df.format(maxSpread));
            input = fio.nextLine();
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

