import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        ArrayList<Minion> minions = new ArrayList<>();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            minions.add(new Minion(fio.nextInt(), fio.nextInt()));
        }
        Collections.sort(minions);
        int index = -1;
        int numberOfRooms = 0;
        boolean[] accommodatedMinions = new boolean[n];
        while (index < n) {
            index++;
            if (index >= n || accommodatedMinions[index]) {
                continue;
            }
            Minion minion = minions.get(index);
            int maxCount = 0;
            int idealTemperature = minion.coldestTemperature;
            for (int i = minion.coldestTemperature;
                    i <= minion.hottestTemperature; i++) {
                int count = 0;
                int k = index;
                while (minion.canHandleTemperature(i) && k < n) {
                    count++;
                    k++;
                    if (k < n) {
                        minion = minions.get(k);
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    idealTemperature = i;
                }
                minion = minions.get(index);
            }
            for (int i = 0; i < n; i++) {
                if (minions.get(i).canHandleTemperature(idealTemperature)) {
                    accommodatedMinions[i] = true;
                }
            }
            numberOfRooms++;
        }
        fio.println(numberOfRooms);
        fio.close();
    }
}

class Minion implements Comparable<Minion> {

    int coldestTemperature;
    int hottestTemperature;

    Minion(int coldestTemperature, int hottestTemperature) {
        this.coldestTemperature = coldestTemperature;
        this.hottestTemperature = hottestTemperature;
    }

    boolean canHandleTemperature(int temperature) {
        return temperature >= coldestTemperature && temperature <= hottestTemperature;
    }

    @Override
    public int compareTo(Minion other) {
        if (this.coldestTemperature != other.coldestTemperature) {
            return this.coldestTemperature - other.coldestTemperature;
        } else {
            return this.hottestTemperature - other.hottestTemperature;
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

