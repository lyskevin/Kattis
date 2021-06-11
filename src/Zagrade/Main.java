import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    private static char[] expression;
    private static HashSet<String> result = new HashSet<>();
    private static List<Integer> openIndices = new ArrayList<>();
    private static List<Integer> closeIndices = new ArrayList<>();

    public static void main(String[] args) {
        FastIO fio = new FastIO();

        expression = fio.nextLine().toCharArray();

        for (int i = 0; i < expression.length; i++) {
            if (expression[i] == '(') {
                openIndices.add(i);
            } else if (expression[i] == ')') {
                closeIndices.add(i);
            }
        }

        for (int i = 0; i < openIndices.size(); i++) {
            solve(i);
        }

        result.remove(getString());

        List<String> sortedResult = new ArrayList<>();

        for (String s : result) {
            sortedResult.add(s);
        }

        Collections.sort(sortedResult);

        for (String s : sortedResult) {
            fio.println(s);
        }

        fio.close();
    }

    private static void solve(int openIndex) {
        if (openIndex == openIndices.size()) {
            result.add(getString());
            return;
        }

        expression[openIndices.get(openIndex)] = '.';

        for (int i = 0; i < closeIndices.size(); i++) {
            if (expression[closeIndices.get(i)] != '.' && canRemove(openIndex, i)) {
                expression[closeIndices.get(i)] = '.';
                solve(openIndex + 1);
                expression[closeIndices.get(i)] = ')';
            }
        }
        
        expression[openIndices.get(openIndex)] = '(';

        solve(openIndex + 1);
    }

    private static boolean canRemove(int openIndex, int closeIndex) {
        int open = openIndices.get(openIndex);
        int close = closeIndices.get(closeIndex);

        if (open > close) {
            return false;
        }

        int openCount = 0;
        int closeCount = 0;
        int index = 1;

        while (openIndex + index < openIndices.size() && openIndices.get(openIndex + index) < close) {
            index++;
            openCount++;
        }
        
        index = 1;

        while (closeIndex - index >= 0 && closeIndices.get(closeIndex - index) > open) {
            index++;
            closeCount++;
        }

        return openCount == closeCount;
    }

    private static String getString() {
        StringBuilder sb = new StringBuilder();

        for (char c : expression) {
            if (c != '.') {
                sb.append(c);
            }
        }

        return sb.toString();
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

