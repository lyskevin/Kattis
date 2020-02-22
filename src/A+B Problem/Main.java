import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        HashMap<Integer, Long> frequencies = new HashMap<>();
        int n = fio.nextInt();
        int[] numbers = new int[n];
        int numberOfUniqueNumbers = 0;
        for (int i = 0; i < n; i++) {
            int number = fio.nextInt();
            numbers[i] = number;
            if (frequencies.containsKey(number)) {
                frequencies.put(number, frequencies.get(number) + 1);
            } else {
                numberOfUniqueNumbers++;
                frequencies.put(number, 1l);
            }
        }
        int numberCount = 0;
        Arrays.sort(numbers);
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
        int number = 0;
        long numberOfWays = 0l;
        int min = numbers[0];
        int max = numbers[n - 1];
        while (index < n) {
            number = numbers[index];
            // Go in descending order from the middle number; prune once number to be added becomes too small
            int newIndex = middleNumberIndex - 1;
            while (newIndex >= 0) {
                int newNumber = numbers[newIndex];
                int result = number + numbers[newIndex];
                if (result < min) {
                    break;
                }
                long frequency1 = frequencies.get(number).longValue();
                long frequency2 = frequencies.get(newNumber).longValue();
                if (frequencies.containsKey(result)) {
                    long frequency3 = frequencies.get(result).longValue();
                    if (number == newNumber && number == result) {
                        numberOfWays += frequency1 * (frequency2 - 1) * (frequency3 - 2);
                    } else {
                        if (number == newNumber) {
                            frequency1--;
                        }
                        if (number == result) {
                            frequency1--;
                        }
                        if (newNumber == result) {
                            frequency2--;
                        }
                        numberOfWays += frequency1 * frequency2 * frequency3; 
                    }
                }
                newIndex -= (int) frequency2;
            }
            // Go in ascending order from the middle number; prune once number to be added becomes too large
            newIndex = middleNumberIndex;
            while (newIndex < n) {
                int newNumber = numbers[newIndex];
                int result = number + numbers[newIndex];
                if (result > max) {
                    break;
                }
                long frequency1 = frequencies.get(number).longValue();
                long frequency2 = frequencies.get(newNumber).longValue();
                if (frequencies.containsKey(result)) {
                    long frequency3 = frequencies.get(result).longValue();
                    if (number == newNumber && number == result) {
                        numberOfWays += frequency1 * (frequency2 - 1) * (frequency3 - 2);
                    } else {
                        if (number == newNumber) {
                            frequency1--;
                        }
                        if (number == result) {
                            frequency1--;
                        }
                        if (newNumber == result) {
                            frequency2--;
                        }
                        numberOfWays += frequency1 * frequency2 * frequency3; 
                    }
                }
                newIndex += (int) frequency2;
            }
            index += frequencies.get(number).longValue();
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

