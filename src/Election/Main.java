import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        HashMap<String, String> affiliations = new HashMap<>();
        for (int i = 0; i < n; i++) {
            affiliations.put(fio.nextLine(), fio.nextLine());
        }

        int m = fio.nextInt();
        HashMap<String, Integer> votes = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String name = fio.nextLine();
            if (affiliations.containsKey(name)) {
                if (!votes.containsKey(name)) {
                    votes.put(name, 0);
                }
                votes.put(name, votes.get(name) + 1);
            }
        }

        int maxVotes = 0;
        int count = 0;
        String winnerName = "";
        for (String name : votes.keySet()) {
            int currentVotes = votes.get(name);
            if (currentVotes > maxVotes) {
                maxVotes = currentVotes;
                count = 1;
                winnerName = name;
            } else if (currentVotes == maxVotes) {
                count++;
            }
        }

        if (count == 1) {
            fio.println(affiliations.get(winnerName));
        } else {
            fio.println("tie");
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

