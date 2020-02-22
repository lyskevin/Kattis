import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int m = fio.nextInt();
        boolean[] presentGnomes = new boolean[n + 1];
        ArrayList<Integer> gnomes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int gnome = fio.nextInt();
            gnomes.add(gnome);
            presentGnomes[gnome] = true;
        }
        TreeSet<Integer> absentGnomes = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            if (!presentGnomes[i]) {
                absentGnomes.add(i);
            }
        }
        int index = 0;
        while (index < gnomes.size() && !absentGnomes.isEmpty()) {
            if (absentGnomes.first() < gnomes.get(index)) {
                fio.println(absentGnomes.pollFirst());
            } else {
                fio.println(gnomes.get(index));
                index++;
            }
        }
        while (index < gnomes.size()) {
            fio.println(gnomes.get(index));
            index++;
        }
        while (!absentGnomes.isEmpty()) {
            fio.println(absentGnomes.pollFirst());
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

