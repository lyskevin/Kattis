import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static TreeSet<Integer> numbers = new TreeSet<>();

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();
        
        for (int i = 0; i < N; i++) {
            numbers.add(fio.nextInt());
        }

        int A = fio.nextInt();
        int B = fio.nextInt();

        int result = A;
        int distance = getDistance(A);
        
        int nextDistance = getDistance(A + 1);
        if (nextDistance > distance && ((A + 1) % 2 == 1)) {
            result = A + 1;
            distance = nextDistance;
        }
        
        nextDistance = getDistance(B - 1);
        if (nextDistance > distance && ((B - 1) % 2 == 1)) {
            result = B - 1;
            distance = nextDistance;
        }
        
        nextDistance = getDistance(B);
        if (nextDistance > distance && (B % 2 == 1)) {
            result = B;
            distance = nextDistance;
        }

        while (numbers.size() > 1) {
            int first = numbers.pollFirst();
            int next = numbers.first();
            int number = (first + next) / 2;
            if (number % 2 == 1) {
                if (number >= A && number <= B) {
                nextDistance = Math.min(Math.abs(first - number), Math.abs(next - number));
                if (nextDistance > distance) {
                    result = number;
                    distance = nextDistance;
                }
                }
            } else {
                if (number - 1 >= first && number - 1 <= next && number - 1 >= A && number - 1 <= B) {
                    nextDistance = Math.min(Math.abs(first - number + 1), Math.abs(next - number + 1));
                    if (nextDistance > distance) {
                        result = number - 1;
                        distance = nextDistance;
                    }
                }
                if (number + 1 >= first && number + 1 <= next && number + 1 >= A && number + 1 <= B) {
                    nextDistance = Math.min(Math.abs(first - number - 1), Math.abs(next - number - 1));
                    if (nextDistance > distance) {
                        result = number + 1;
                        distance = nextDistance;
                    }
                }
            }
        }

        fio.println(result);

        fio.close();
    }

    private static int getDistance(int number) {
        Integer floor = numbers.floor(number);
        Integer ceiling = numbers.ceiling(number);
        if (floor == null) {
            return Math.abs(ceiling - number);
        } else if (ceiling == null) {
            return Math.abs(floor - number);
        } else {
            return Math.min(Math.abs(ceiling - number), Math.abs(floor - number));
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

