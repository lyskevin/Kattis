import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        int m = fio.nextInt();
        Researcher[] researchers = new Researcher[n];
        for (int i = 0; i < n; i++) {
            researchers[i] = new Researcher(fio.nextInt(), fio.nextInt());
        }
        Arrays.sort(researchers);

        PriorityQueue<Integer> workstations = new PriorityQueue<>();
        int numberOfUnlocks = 0;
        for (int i = 0; i < n; i++) {
            boolean isFound = false;
            Researcher researcher = researchers[i];            

            while (!isFound && !workstations.isEmpty()) {
                if (workstations.peek() > researcher.a) {
                    break;
                } else {
                    int workstation = workstations.poll();
                    if (workstation <= researcher.a && workstation + m >= researcher.a) {
                        isFound = true;
                    }
                }
            }

            if (!isFound) {
                numberOfUnlocks++;
            }
            workstations.offer(researcher.a + researcher.s);
        }

        fio.println(n - numberOfUnlocks);
        fio.close();
    }
}

class Researcher implements Comparable<Researcher> {
    int a;
    int s;

    Researcher(int a, int s) {
        this.a = a;
        this.s = s;
    }

    @Override
    public int compareTo(Researcher other) {
        return this.a - other.a;
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

