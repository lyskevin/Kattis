import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        TreeSet<Cat> cats = new TreeSet<>();
        HashMap<String, Pair> infectionLevels = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int query = fio.nextInt();
            if (query == 0) {
                String name = fio.next();
                int infectionLevel = fio.nextInt();
                cats.add(new Cat(name, infectionLevel, count));
                infectionLevels.put(name, new Pair(infectionLevel, count));
                count++;
            } else if (query == 1) {
                String name = fio.next();
                int increase = fio.nextInt();
                Pair data = infectionLevels.get(name);
                cats.remove(new Cat(name, data.a, data.b));
                infectionLevels.put(name, new Pair(data.a + increase, data.b));
                cats.add(new Cat(name, data.a + increase, data.b));
            } else if (query == 2) {
                String name = fio.next();
                Pair data = infectionLevels.get(name);
                cats.remove(new Cat(name, data.a, data.b));
            } else {
                if (cats.isEmpty()) {
                    fio.println("The clinic is empty");
                } else {
                    fio.println(cats.last().name);
                }
            }
        }
        fio.close();
    }
}

class Pair {

    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

}

class Cat implements Comparable<Cat> {

    String name;
    int infectionLevel;
    int arrivalTime;

    Cat(String name, int infectionLevel, int arrivalTime) {
        this.name = name;
        this.infectionLevel = infectionLevel;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int compareTo(Cat other) {
        if (this.infectionLevel != other.infectionLevel) {
            return this.infectionLevel - other.infectionLevel;
        }
        return other.arrivalTime - this.arrivalTime;
    }

    @Override
    public boolean equals(Object other) {
        Cat otherCat = (Cat) other;
        return this.name.equals(otherCat.name) && this.infectionLevel == otherCat.infectionLevel
                && this.arrivalTime == otherCat.arrivalTime;
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

