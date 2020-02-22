import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int a = fio.nextInt();
        int b = fio.nextInt();
        int e = fio.nextInt();
        int p = fio.nextInt();
        int[] numberOfSteps = new int[e];
        boolean[] isVisited = new boolean[e];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < p; i++) {
            adjList.get(fio.nextInt()).add(fio.nextInt());
        }
        for (int i = 0; i < e; i++) {
            if (!isVisited[i]) {
                dfs(i, 0, numberOfSteps, adjList, isVisited);
            }
        }
        int[] stepFrequency = new int[p];
        for (int i = 0; i < e; i++) {
            int f = numberOfSteps[i];
            if (f == 0) {
                fio.println(i);
            }
            stepFrequency[numberOfSteps[i]] += 1;
        }
        int minGuaranteedPromotions = 0;
        boolean minFound = false;
        int maxGuaranteedPromotions = 0;
        int noPossibility = 0;
        for (int i = 0; i < p; i++) {
            int frequency = stepFrequency[i];
            if (!minFound && minGuaranteedPromotions + frequency <= a) {
                minGuaranteedPromotions += frequency;
            } else {
                minFound = true;
            }
            if (maxGuaranteedPromotions + frequency < b) {
                maxGuaranteedPromotions += frequency;
            } else if (maxGuaranteedPromotions + frequency == b) {
                maxGuaranteedPromotions += frequency;
                noPossibility = e - maxGuaranteedPromotions;
                break;
            } else {
                noPossibility = e - maxGuaranteedPromotions - frequency;
                break;
            }
        }
        fio.println(minGuaranteedPromotions);
        fio.println(maxGuaranteedPromotions);
        fio.println(noPossibility);
        fio.close();
    }

    private static void dfs(int employee, int currentNumberOfSteps, int[] numberOfSteps,
            ArrayList<ArrayList<Integer>> adjList, boolean[] isVisited) {
        isVisited[employee] = true;
        numberOfSteps[employee] = Math.max(numberOfSteps[employee], currentNumberOfSteps);
        for (Integer neighbour : adjList.get(employee)) {
            if (!isVisited[neighbour]) {
                dfs(neighbour, currentNumberOfSteps + 1, numberOfSteps, adjList, isVisited);
            } else if (currentNumberOfSteps + 1 > numberOfSteps[neighbour]) {
                numberOfSteps[neighbour] = currentNumberOfSteps + 1;
            }
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

