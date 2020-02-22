import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int k = fio.nextInt();
        Queue<String>[] owners = new Queue[n];
        for (int i = 0; i < n; i++) {
            owners[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            int q = fio.nextInt();
            for (int j = 0; j < q; j++) {
                owners[i].offer(fio.next());
            }
        }
        int p = fio.nextInt();
        TreeSet<Player> players = new TreeSet<>();
        HashMap<String, Player> remainingNames = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < p; i++) {
            String name = fio.nextLine();
            Player player = new Player(name, rank);
            players.add(player);
            remainingNames.put(name, player);
            rank++;
        }
        // Simulate finding players by owners' preferences first, then by prior ranking
        String[][] teams = new String[n][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                boolean playerFound = false;
                // Current owner's preference list still has players in it
                while (!owners[j].isEmpty() && !playerFound) {
                    String name = owners[j].poll();
                    if (remainingNames.containsKey(name)) {
                        Player player = remainingNames.remove(name);
                        players.remove(player);
                        teams[j][i] = player.name;
                        playerFound = true;
                    }
                }
                // Use prior ranking
                if (!playerFound) {
                    Player player = players.pollFirst();
                    remainingNames.remove(player.name);
                    teams[j][i] = player.name;
                }
            }
        }
        // Print formatted output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (j > 0) {
                    fio.print(" ");
                }
                fio.print(teams[i][j]);
            }
            fio.println();
        }
        fio.close();
    }
}

class Player implements Comparable<Player> {

    String name;
    int rank;

    Player(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(Player other) {
        return this.rank - other.rank;
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

