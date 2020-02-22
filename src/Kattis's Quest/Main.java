import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.StringBuilder;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfCommands = fr.nextInt();
        TreeMap<Integer, PriorityQueue<Integer>> quests = new TreeMap<>();
        Comparator<Integer> goldComparator = new Comparator<>() {
            @Override
            public int compare(Integer gold1, Integer gold2) {
                return gold1.compareTo(gold2) * -1;
            }
        };
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numberOfCommands; i++) {
            String command = fr.next();
            if (command.equals("add")) {
                int energy = fr.nextInt();
                int gold = fr.nextInt();
                if (quests.containsKey(energy)) {
                    quests.get(energy).offer(gold);
                } else {
                    PriorityQueue<Integer> goldPQ =
                        new PriorityQueue<>(goldComparator);
                    goldPQ.add(gold);
                    quests.put(energy, goldPQ);
                }
            } else {
                int energy = fr.nextInt();
                long totalGold = 0;
                while (energy > 0) {
                    Integer floorEnergy = quests.floorKey(energy);
                    if (floorEnergy == null) {
                        break;
                    }
                    PriorityQueue<Integer> goldPQ = quests.get(floorEnergy);
                    while (!goldPQ.isEmpty() && energy >= floorEnergy) {
                        totalGold += goldPQ.poll();
                        energy -= floorEnergy;
                    }
                    if (goldPQ.isEmpty()) {
                        quests.remove(floorEnergy);
                    }  
                }
                output.append(totalGold);
                output.append("\n");
            }
        }
        System.out.print(output);
    }
}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
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

