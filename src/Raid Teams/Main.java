import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        Player[] players1 = new Player[n];
        Player[] players2 = new Player[n];
        Player[] players3 = new Player[n];
        HashSet<String> availablePlayers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = fio.next();
            availablePlayers.add(name);
            Player p = new Player(name, fio.nextInt(), fio.nextInt(), fio.nextInt());
            players1[i] = p;
            players2[i] = p;
            players3[i] = p;
        }
        // Sort the 3 arrays according to the 3 respective skill levels
        Arrays.sort(players1, (x, y) -> x.s1 == y.s1 ? x.name.compareTo(y.name) : y.s1 - x.s1);
        Arrays.sort(players2, (x, y) -> x.s2 == y.s2 ? x.name.compareTo(y.name) : y.s2 - x.s2);
        Arrays.sort(players3, (x, y) -> x.s3 == y.s3 ? x.name.compareTo(y.name) : y.s3 - x.s3);
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        // Select players
        while (index1 < n && index2 < n && index3 < n) {
            Player p1 = null;
            Player p2 = null;
            Player p3 = null;
            while (p1 == null && index1 < n) {
                if (availablePlayers.contains(players1[index1].name)) {
                    p1 = players1[index1];
                    availablePlayers.remove(p1.name);
                }
                index1++;
            }
            while (p2 == null && index2 < n) {
                if (availablePlayers.contains(players2[index2].name)) {
                    p2 = players2[index2];
                    availablePlayers.remove(p2.name);
                }
                index2++;
            }
            while (p3 == null && index3 < n) {
                if (availablePlayers.contains(players3[index3].name)) {
                    p3 = players3[index3];
                    availablePlayers.remove(p3.name);
                }
                index3++;
            }
            // Only print team if 3 players can be selected
            if (p1 != null && p2 != null && p3 != null) {
                String[] names = {p1.name, p2.name, p3.name};
                Arrays.sort(names, (x, y) -> x.compareTo(y));
                fio.println(names[0] + " " + names[1] + " " + names[2]);
            }
        }
        fio.close();
    }
}

class Player {

    String name;
    int s1;
    int s2;
    int s3;

    Player(String name, int s1, int s2, int s3) {
        this.name = name;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
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

