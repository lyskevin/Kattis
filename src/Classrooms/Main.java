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
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(fio.nextInt(), fio.nextInt());
        }
        Arrays.sort(intervals);
        TreeMap<Integer, Integer> classrooms = new TreeMap<>();
        classrooms.put(0, k);
        int count = 0;
        for (int i = 0; i < n; i++) {
            Integer closestEndTime = classrooms.lowerKey(intervals[i].start);
            if (closestEndTime != null) {
                Integer endTimeFrequency = classrooms.get(closestEndTime);
                if (endTimeFrequency.intValue() > 1) {
                    classrooms.put(closestEndTime, endTimeFrequency - 1);
                } else {
                    classrooms.remove(closestEndTime);
                }
                Integer nextEndTimeFrequency = Integer.valueOf(1);
                if (classrooms.containsKey(intervals[i].end)) {
                    nextEndTimeFrequency += classrooms.get(intervals[i].end);
                }
                classrooms.put(intervals[i].end, nextEndTimeFrequency);
                count++;
            }
        }
        fio.println(count);
        fio.close();
    }
}

class Interval implements Comparable<Interval> {

    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
        public int compareTo(Interval other) {
            return this.end == other.end ? this.start - other.start : this.end - other.end;
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

