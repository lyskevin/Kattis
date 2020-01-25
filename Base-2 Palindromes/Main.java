import java.io.*;
import java.util.*;
import java.math.BigInteger;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int m = fio.nextInt();
        if (m == 1) {
            fio.println("1");
        } else if (m == 2) {
            fio.println("3");
        } else {
            // Store palindromes of length 1 and 2 to generate subsequent palindromes
            ArrayList<ArrayList<String>> palindromes = new ArrayList<>();
            ArrayList<String> length1Palindromes = new ArrayList<>();
            length1Palindromes.add("0");
            length1Palindromes.add("1");
            palindromes.add(length1Palindromes);
            ArrayList<String> length2Palindromes = new ArrayList<>();
            length2Palindromes.add("00");
            length2Palindromes.add("11");
            palindromes.add(length2Palindromes);
            int count = 2; // Only consider 1 and 11 in the palindrome count (i.e. no leading zeroes)
            int currentLength = 3;
            boolean answerFound = false;
            String answer = "";
            while (!answerFound) {
                ArrayList<String> newPalindromes = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                // Add palindromes with 0s at both ends but do not increment the counter
                for (String oldPalindrome : palindromes.get(currentLength - 3)) {
                    sb = new StringBuilder("0");
                    sb.append(oldPalindrome);
                    sb.append("0");
                    newPalindromes.add(sb.toString());
                }
                // Add palindromes with 1s at both ends and increment the counter
                for (String oldPalindrome : palindromes.get(currentLength - 3)) {
                    sb = new StringBuilder("1");
                    sb.append(oldPalindrome);
                    sb.append("1");
                    count++;
                    if (count == m) {
                        answerFound = true;
                        answer = sb.toString();
                        break;
                    }
                    newPalindromes.add(sb.toString());
                }
                palindromes.add(newPalindromes);
                currentLength++;
            }
            // Print answer in base 10
            fio.println(new BigInteger(answer, 2));
        }
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

