import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static Tuple[] typeOnes;
    private static Tuple[] typeTwos;

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int T = fio.nextInt();
        int N = fio.nextInt();
        typeOnes = new Tuple[N];

        for (int i = 0; i < N; i++) {
            typeOnes[i] = new Tuple(fio.nextInt(), fio.nextInt());
        }

        int M = fio.nextInt();
        typeTwos = new Tuple[M];

        for (int i = 0; i < M; i++) {
            typeTwos[i] = new Tuple(fio.nextInt(), fio.nextInt());
        }

        int low = 1;
        int high = T;
        int guess = (low + high) / 2;

        while (low <= high) {
            int status = validateGuess(guess, T);

            if (status == 0) { // Match
                break;
            } else if (status == -1) { // Decrease picking time (guess)
                high = guess - 1;
            } else { // Decrease peeling time
                low = guess + 1;
            }

            guess = (low + high) / 2;
        }

        fio.println(guess);

        fio.close();
    }

    private static int validateGuess(int guess, int T) {
        long numberPicked = 0;
        boolean didPickOnTime = false;

        for (int i = 0; i < typeOnes.length; i++) {
            int A = typeOnes[i].first;
            int B = typeOnes[i].second;

            if (A <= guess) {
                numberPicked += (guess - A) / B + 1;
                didPickOnTime = didPickOnTime || (guess - A) % B == 0;
            }
        }

        long numberPeeled = 0;
        boolean didPeelOnTime = false;

        for (int i = 0; i < typeTwos.length; i++) {
            int C = typeTwos[i].first;
            int D = typeTwos[i].second;

            if (guess + C <= T) {
                numberPeeled += (T - guess - C) / D + 1;
                didPeelOnTime = didPeelOnTime || (T - guess - C) % D == 0;
            }
        }

        if (numberPicked > numberPeeled) {
            return -1;
        }

        if (numberPicked < numberPeeled) {
            return 1;
        }

        if (!didPickOnTime) {
            return -1;
        }

        if (!didPeelOnTime) {
            return 1;
        }

        return 0;
    }
}

class Tuple {
    int first;
    int second;

    Tuple(int first, int second) {
        this.first = first;
        this.second = second;
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

