import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        HashMap<String, Integer> variableValues = new HashMap<>();
        String input = fio.nextLine();

        while(!input.equals("0")) {
            String[] tokens = input.split(" ");

            if (tokens.length >= 3 && tokens[1].equals("=")) {
                variableValues.put(tokens[0], Integer.parseInt(tokens[2]));
            } else {
                int sum = 0;
                ArrayList<String> undefinedVariables = new ArrayList<>();

                for (String token : tokens) {
                    if (token.equals("+")) {
                        continue;
                    }

                    if (isInteger(token)) {
                        sum += Integer.parseInt(token);
                    } else if (variableValues.containsKey(token)) {
                        sum += variableValues.get(token);
                    } else {
                        undefinedVariables.add(token);
                    }
                }

                if (sum == 0 && undefinedVariables.isEmpty()) {
                    fio.println(0);
                } else {
                    boolean isFirst = true;

                    if (sum > 0) {
                        fio.print(sum);
                        isFirst = false;
                    }

                    for (String undefinedVariable : undefinedVariables) {
                        if (isFirst) {
                            isFirst = false;
                        } else {
                            fio.print(" + ");
                        }

                        fio.print(undefinedVariable);
                    }

                    fio.println();
                }
            }

            input = fio.nextLine();
        }

        fio.close();
    }

    private static boolean isInteger(String string) {
        try {
            int integer = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
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

