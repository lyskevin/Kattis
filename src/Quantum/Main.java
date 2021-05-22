import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int N = fio.nextInt();

        for (int i = 0; i < N; i++) {
            int L = fio.nextInt();
            int nop = fio.nextInt();
            int nw = fio.nextInt();
            Operation[] ops = new Operation[nop];

            for (int j = 0; j < nop; j++) {
                ops[j] = new Operation(fio.next(), fio.nextInt());
            }

            for (int j = 0; j < nw; j++) {
                if (j > 0) {
                    fio.print(" ");
                }

                int start = toBits(fio.next());
                int end = toBits(fio.next());

                HashMap<Integer, Integer> costs = new HashMap<>(); // Expensive to keep initialising array with large values
                costs.put(start, 0);
                PriorityQueue<State> pq = new PriorityQueue<>();
                pq.offer(new State(start, 0));

                while(!pq.isEmpty()) {
                    State state = pq.poll();

                    if (state.bits == end) {
                        break;
                    }

                    if (costs.containsKey(state.bits) && costs.get(state.bits) < state.cost) {
                        continue; // Lazy DS
                    }

                    for (Operation op : ops) {
                        int nextBits = op.transform(state.bits);
                        int nextCost = state.cost + op.cost;

                        if (!costs.containsKey(nextBits)
                                || (costs.containsKey(nextBits) && costs.get(nextBits) > nextCost)) {
                            costs.put(nextBits, nextCost);
                            pq.offer(new State(nextBits, nextCost));
                        }
                    }
                }

                if (costs.containsKey(end)) {
                    fio.print(costs.get(end));
                } else {
                    fio.print("NP");
                }
            }

            fio.println();
        }

        fio.close();
    }

    private static int toBits(String string) {
        int result = 0;

        for (int i = 0; i < string.length(); i++) {
            int bitmask = 1 << (string.length() - 1 - i);

            if (string.charAt(i) == '1') {
                result |= bitmask;
            }
        }

        return result;
    }
}

class Operation {
    String operation;
    int cost;

    Operation(String operation, int cost) {
        this.operation = operation;
        this.cost = cost;
    }

    int transform(int bits) {
        for (int i = 0; i < operation.length(); i++) {
            int bitmask = 1 << (operation.length() - 1 - i);

            if (operation.charAt(i) == 'F') {
                bits ^= bitmask;
            } else if (operation.charAt(i) == 'S') {
                bits |= bitmask;
            } else if (operation.charAt(i) == 'C') {
                bits &= ~bitmask;
            }
        }

        return bits;
    }
}

class State implements Comparable<State> {
    int bits;
    int cost;

    State(int bits, int cost) {
        this.bits = bits;
        this.cost = cost;
    }

    @Override
    public int compareTo(State other) {
        if (this.cost != other.cost) {
            return this.cost - other.cost;
        }

        return this.bits - other.bits;
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

