import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fio.nextInt();
            int m = fio.nextInt();
            int l = fio.nextInt();
            ArrayList<Agency> agencies = new ArrayList<>();
            for (int j = 0; j < l; j++) {
                String input = fio.nextLine();
                String[] information = input.split(":");
                String name = information[0];
                String[] rates = information[1].split(",");
                int a = Integer.parseInt(rates[0]);
                int b = Integer.parseInt(rates[1]);
                int cost = calculateCost(n, m, a, b);
                agencies.add(new Agency(name, cost));
            }
            Collections.sort(agencies);
            fio.println("Case " + (i + 1));
            for (Agency agency : agencies) {
                fio.println(agency.name + " " + agency.cost);
            }
        }
        fio.close();
    }

    // Keep dividing by 2 as much as possible before reducing by 1
    private static int calculateCost(int n, int m, int a, int b) {
        int cost = 0;
        while (n > m) {
            if (n >= 2 * m) {
                // Tricky part; might be cheaper to keep reducing by 1 to get the same effect as dividing by 2
                if ((n - (n / 2)) * a < b) {
                    cost += (n - (n / 2)) * a;
                } else {
                    cost += b;
                }
                n /= 2;
            } else {
                cost += a * (n - m);
                n = m;
            }
        }
        return cost;
    }

}

class Agency implements Comparable<Agency> {

    String name;
    int cost;

    Agency(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int compareTo(Agency other) {
        if (this.cost != other.cost) {
            return this.cost - other.cost;
        } else {
            return this.name.compareTo(other.name);
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

