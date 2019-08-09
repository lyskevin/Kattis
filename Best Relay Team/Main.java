import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lyskevin
 */
public class Main {

    private static final double INF = 1000000;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        Comparator<Runner> runnerComparator = new Comparator<>() {
            @Override
            public int compare(Runner runner1, Runner runner2) {
                return Double.compare(runner1.time, runner2.time);
            }
        };
        int numberOfRunners = fr.nextInt();
        Runner[] firstRunners = new Runner[numberOfRunners];
        Runner[] subsequentRunners = new Runner[numberOfRunners];
        for (int i = 0; i < numberOfRunners; i++) {
            String name = fr.next();
            double firstLapTime = fr.nextDouble();
            double subsequentLapTime = fr.nextDouble();
            firstRunners[i] = new Runner(name, firstLapTime);
            subsequentRunners[i] = new Runner(name, subsequentLapTime);
        }
        Arrays.sort(firstRunners, runnerComparator);
        Arrays.sort(subsequentRunners, runnerComparator);
        double totalTime = INF;
        String[] finalRunners = new String[4];
        for (int i = 0; i < numberOfRunners; i++) {
            String[] newFinalRunners = new String[4];
            Runner firstRunner = firstRunners[i];
            newFinalRunners[0] = firstRunner.name;
            double newTotalTime = firstRunner.time;
            int j = 0;
            for (int k = 0; k < 3; k++) {
                Runner nextRunner = subsequentRunners[j];
                if (nextRunner.name.equals(firstRunner.name)) {
                    j++;
                    nextRunner = subsequentRunners[j];
                }
                newFinalRunners[k + 1] = nextRunner.name;
                newTotalTime += nextRunner.time;
                j++;
            }
            if (newTotalTime < totalTime) {
                totalTime = newTotalTime;
                finalRunners = newFinalRunners;
            }
        }
        System.out.println(totalTime);
        for (int i = 0; i < 4; i++) {
            System.out.println(finalRunners[i]);
        }
    }
}

class Runner {

    String name;
    double time;

    Runner(String name, double time) {
        this.name = name;
        this.time = time;
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

