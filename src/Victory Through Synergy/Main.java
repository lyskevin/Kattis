import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static boolean[][] adjMatrix = new boolean[10][10];
    private static Player[] players = new Player[10];
    private static int[][] synergies = new int[10][10];
    private static int[] assignments = new int[10];
    private static boolean[] usedPlayers = new boolean[10];

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int c = fio.nextInt();
        for (int i = 0; i < c; i++) {
            int node1 = fio.nextInt();
            int node2 = fio.nextInt();
            adjMatrix[node1][node2] = true;
            adjMatrix[node2][node1] = true;
        }
        for (int i = 0; i < 10; i++) {
            players[i] = new Player(fio.next(), fio.next(), fio.next(), fio.next());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                int synergy = players[i].getSynergy(players[j]);
                synergies[i][j] = synergies[j][i] = synergy;
            }
        }
        if (hasPerfectTeam(0)) {
            fio.println("yes");
        } else {
            fio.println("no");
        }
        fio.close();
    }

    private static boolean hasPerfectTeam(int index) {
        if (index == 10) {
            // Calculate synergy
            for (int i = 0; i < 10; i++) {
                int synergy = 0;
                int count = 0;
                for (int j = 0; j < 10; j++) {
                    if (adjMatrix[i][j]) {
                        synergy += synergies[assignments[i]][assignments[j]];
                        count++;
                    }
                }
                if (synergy < count) {
                    return false;
                }
            }
            return true;
        }
        // Generate permutations
        for (int i = 0; i < 10; i++) {
            if (!usedPlayers[i]) {
                usedPlayers[i] = true;
                assignments[index] = i;
                if (hasPerfectTeam(index + 1)) {
                    return true;
                }
                usedPlayers[i] = false;
            }
        }
        return false;
    }

}

class Player {
    
    String name;
    String nation;
    String league;
    String team;

    Player(String name, String nation, String league, String team) {
        this.name = name;
        this.nation = nation;
        this.league = league;
        this.team = team;
    }

    int getSynergy(Player other) {
        if (this.nation.equals(other.nation) && this.team.equals(other.team)) {
            return 3;
        } else if ((this.nation.equals(other.nation) && this.league.equals(other.league))
                || this.team.equals(other.team)) {
            return 2;
        } else if (this.league.equals(other.league) || this.nation.equals(other.nation)) {
            return 1;
        } else {
            return 0;
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

