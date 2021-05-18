import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static TreeMap<Integer, ArrayList<Team>> dynasties = new TreeMap<>();
    private static Queue<String> players = new LinkedList<>();

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            players.offer(fio.next());
        }

        String player1 = players.poll();
        String player2 = players.poll();
        String player3 = players.poll();
        String player4 = players.poll();

        Team whiteTeam = new Team(player1, player3, player1, player3);
        Team blackTeam = new Team(player2, player4, player2, player4);
        String scores = fio.nextLine();

        for (int i = 0; i < scores.length(); i++) {
            if (scores.charAt(i) == 'W') {
                whiteTeam.scoreGoal();
                blackTeam = getNextTeam(blackTeam);
            } else {
                blackTeam.scoreGoal();
                whiteTeam = getNextTeam(whiteTeam);
            }
            
            // Does not matter if we add dynasty for scoring team
            // since we only care about the dynasties with the highest score;
            // i.e. for every highest scoring dynasty, it does not matter
            // if the same team has a lower score as its key in the TreeMap
            addDynasty(whiteTeam);
            addDynasty(blackTeam);

        }

        int highestScore = dynasties.lastKey();
        for (Team team : dynasties.get(highestScore)) {
            fio.println(team);
        }

        fio.close();
    }

    private static void addDynasty(Team team) {
        if (!dynasties.containsKey(team.score)) {
            dynasties.put(team.score, new ArrayList<>());
        }
        dynasties.get(team.score).add(team);
    }

    private static Team getNextTeam(Team losingTeam) {
        players.offer(losingTeam.defence);
        String nextPlayer = players.poll();
        return new Team(losingTeam.offence, nextPlayer, nextPlayer, losingTeam.offence);
    }
}

class Team {
    String first;
    String second;
    String offence;
    String defence;
    int score;

    Team(String first, String second, String offence, String defence) {
        this.first = first;
        this.second = second;
        this.offence = offence;
        this.defence = defence;
        this.score = 0;
    }

    void scoreGoal() {
        score++;
        String temp = offence;
        offence = defence;
        defence = temp;
    }

    @Override
    public String toString() {
        return first + " " + second;
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

