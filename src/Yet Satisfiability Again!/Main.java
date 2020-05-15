import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int n;
    private static int m;
    private static int[][] clauses;
    private static int[] variableAssignments;
    private static boolean isSatisfiable;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            n = fio.nextInt();
            m = fio.nextInt();
            clauses = new int[m][];
            for (int j = 0; j < m; j++) {
                String[] literals = fio.nextLine().split(" v ");
                int[] clause = new int[literals.length];
                for (int k = 0; k < literals.length; k++) {
                    // -1: false, 1: true, 0: variable not used in clause
                    if (literals[k].charAt(0) == '~') {
                        clause[k] = Integer.parseInt(literals[k].substring(2, literals[k].length())) * -1;
                        
                    } else {
                        clause[k] = Integer.parseInt(literals[k].substring(1, literals[k].length()));
                    }
                }
                clauses[j] = clause;
            }
            isSatisfiable = false;
            variableAssignments = new int[n + 1];
            checkSatisfiability(1);
            if (isSatisfiable) {
                fio.println("satisfiable");
            } else {
                fio.println("unsatisfiable");
            }
        }
        fio.close();
    }

    private static void checkSatisfiability(int index) {
        if (!isSatisfiable) {
            if (index > n) {
                boolean isSatisfyingAssignment = true;
                for (int i = 0; i < m && isSatisfyingAssignment; i++) {
                    boolean isClauseSatisfied = false;
                    int[] clause = clauses[i];
                    for (int j = 0; j < clause.length && !isClauseSatisfied; j++) {
                        if (clause[j] != 0 && variableAssignments[Math.abs(clause[j])] * clause[j] > 0) {
                            isClauseSatisfied = true; // Clause is satisfied once one literal is satisfied
                        }
                    }
                    isSatisfyingAssignment = isClauseSatisfied;
                }
                if (isSatisfyingAssignment) {
                    isSatisfiable = true;
                }
                return;
            }
            // Set current variable's value to false
            variableAssignments[index] = -1;
            checkSatisfiability(index + 1);
            // Set current variable's value to true
            variableAssignments[index] = 1;
            checkSatisfiability(index + 1);
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

