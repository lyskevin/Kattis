import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int m = fio.nextInt();
            HashMap<String, Integer> devices = new HashMap<>();
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            int deviceCounter = 0;
            for (int j = 0; j < m; j++) {
                String device1 = fio.next();
                String device2 = fio.next();
                // Map devices to integers
                if (!devices.containsKey(device1)) {
                    devices.put(device1, deviceCounter);
                    deviceCounter++;
                    adjList.add(new ArrayList<>());
                }
                if (!devices.containsKey(device2)) {
                    devices.put(device2, deviceCounter);
                    deviceCounter++;
                    adjList.add(new ArrayList<>());
                }
                
                adjList.get(devices.get(device1)).add(devices.get(device2));
                adjList.get(devices.get(device2)).add(devices.get(device1));
            }
            // BFS with pruning at a distance of 6
            int numberOfDevicesOnList = 0;
            for (int j = 0; j < adjList.size(); j++) {
                Queue<Vertex> bfsQueue = new LinkedList<>();
                bfsQueue.add(new Vertex(j, 0));
                boolean[] visited = new boolean[adjList.size()];
                visited[i] = true;
                int numberOfConnectedDevices = 1;
                while (!bfsQueue.isEmpty()) {
                    Vertex u = bfsQueue.poll();
                    for (Integer otherDevice : adjList.get(u.device)) {
                        if (u.distance < 6 && !visited[otherDevice]) {
                            visited[otherDevice] = true;
                            bfsQueue.add(new Vertex(otherDevice, u.distance + 1));
                            numberOfConnectedDevices++;
                        }
                    }
                }
                if (numberOfConnectedDevices < adjList.size()) {
                    numberOfDevicesOnList++;
                }
            }
            // Use integer multiplication instead of double to compare percentages
            if (numberOfDevicesOnList * 20 <= adjList.size()) {
                fio.println("YES");
            } else {
                fio.println("NO");
            }
        }
        fio.close();
    }
}

class Vertex {

    int device;
    int distance;

    Vertex(int device, int distance) {
        this.device = device;
        this.distance = distance;
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

