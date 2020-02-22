import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        for (int i = 0; i < n; i++) {
            String commands = fio.nextLine();
            int p = fio.nextInt();
            String list = fio.nextLine();
            String[] integers = list.substring(1, list.length() - 1).split(",");
            // Add integers to deque
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < integers.length; j++) {
                if (!integers[j].equals("")) {
                    deque.addLast(Integer.parseInt(integers[j]));
                }
            }
            // Perform operations
            boolean isReverse = false;
            boolean hasError = false;
            for (int j = 0; j < commands.length() && !hasError; j++) {
                char command = commands.charAt(j);
                if (command == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (deque.isEmpty()) {
                        hasError = true;
                    } else if (!isReverse) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }
            // Format and print output
            if (hasError) {
                fio.println("error");
            } else {
                fio.print("[");
                if (isReverse) {
                    Stack<Integer> stack = new Stack<>();
                    for (int j = 0, k = deque.size(); j < k; j++) {
                        stack.push(deque.removeFirst());
                    }
                    for (int j = 0, k = stack.size(); j < k; j++) {
                        if (j > 0) {
                            fio.print(",");
                        }
                        fio.print(stack.pop());
                    }
                } else {
                    for (int j = 0, k = deque.size(); j < k; j++) {
                        if (j > 0) {
                            fio.print(",");
                        }
                        fio.print(deque.removeFirst());
                    }
                }
                fio.println("]");
            }
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

