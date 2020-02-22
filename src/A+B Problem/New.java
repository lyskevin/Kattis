import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class New {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        long[] frequencies = new long[50001];
        int n = fio.nextInt();
        int[] numbers = new int[n];
        int numberOfUniqueNumbers = 0;
        for (int i = 0; i < n; i++) {
            int number = fio.nextInt();
            numbers[i] = number;
            if (frequencies[number] == 0) {
                numberOfUniqueNumbers++;
            }
            frequencies[number]++;
        }
        Arrays.sort(numbers);
        int numberCount = 0;
        int current = 100000;
        int middleNumberIndex = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] != current) {
                numberCount++;
                current = numbers[i];
            }
            if (numberCount == (numberOfUniqueNumbers + 1) / 2) {
                middleNumberIndex = i;
                break;
            }
        }
        int index = 0;
        long numberOfWays = 0l;
        int min = numbers[0];
        int max = numbers[n - 1];
        while (index < n) {
            int number = numbers[index];
            // Go in descending order from the middle number; prune once number to be added becomes too small
            int newIndex = middleNumberIndex;
            while (newIndex >= 0) {
                if (newIndex != index) {
                    int newNumber = numbers[newIndex];
                    int result = number + numbers[newIndex];
                    if ((newNumber < 0 && result < min) || (newNumber >= 0 && result > max)) {
                        break;
                    }
                    numberOfWays += frequencies[result];
                }
                newIndex--;
            }
            // Go in ascending order from the middle number; prune once number to be added becomes too large
            newIndex = middleNumberIndex + 1;
            while (newIndex < n) {
                if (newIndex != index) {
                    int newNumber = numbers[newIndex];
                    int result = number + numbers[newIndex];
                    if ((newNumber < 0 && result < min) || (newNumber >= 0 && result > max)) {
                        break;
                    }
                    numberOfWays += frequencies[result];
                }
                newIndex++;
            }
            index++;
        }
        fio.println(numberOfWays);
        fio.close();
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

