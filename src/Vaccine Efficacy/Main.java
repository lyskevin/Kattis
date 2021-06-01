import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();
        int[] vaccinated = new int[4];
        int[] control = new int[4];

        for (int i = 0; i < N; i++) {
            String input = fio.nextLine();
            int[] group = input.charAt(0) == 'Y' ? vaccinated : control;
            group[0]++;

            for (int j = 1; j < 4; j++) {
                group[j] += input.charAt(j) == 'Y' ? 1 : 0;
            }
        }

        for (int i = 1; i < 4; i++) {
            double vaccinatedInfectionRate = 1.0 *  vaccinated[i] / vaccinated[0];
            double controlInfectionRate = 1.0 *  control[i] / control[0];
            double change = controlInfectionRate - vaccinatedInfectionRate;
            double effectiveness = (change / controlInfectionRate) * 100;
            fio.println(effectiveness > 0 ? effectiveness : "Not Effective");
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

