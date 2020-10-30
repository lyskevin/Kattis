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
            int n = fio.nextInt();
            PriorityQueue<Order> buyOrders = new PriorityQueue<>((x, y) -> y.price - x.price);
            PriorityQueue<Order> sellOrders = new PriorityQueue<>((x, y) -> x.price - y.price);
            int stockPrice = -1;
            for (int j = 0; j < n; j++) {
                // Add current order
                String[] s = fio.nextLine().split(" ");
                if (s[0].equals("buy")) {
                    buyOrders.offer(new Order(Integer.parseInt(s[4]), Integer.parseInt(s[1])));
                } else {
                    sellOrders.offer(new Order(Integer.parseInt(s[4]), Integer.parseInt(s[1])));
                }
                
                // Process orders until no more deals can be made with the current orders
                while (!buyOrders.isEmpty() && !sellOrders.isEmpty() && buyOrders.peek().price >= sellOrders.peek().price) {
                    Order buyOrder = buyOrders.poll();
                    Order sellOrder = sellOrders.poll();
                    if (buyOrder.shares > sellOrder.shares) {
                        buyOrders.offer(new Order(buyOrder.price, buyOrder.shares - sellOrder.shares));
                    } else if (buyOrder.shares < sellOrder.shares) {
                        sellOrders.offer(new Order(sellOrder.price, sellOrder.shares - buyOrder.shares));
                    }
                    stockPrice = sellOrder.price;
                }

                if (sellOrders.isEmpty()) {
                    fio.print("-");
                } else {
                    fio.print(sellOrders.peek().price);
                }
                fio.print(" ");

                if (buyOrders.isEmpty()) {
                    fio.print("-");
                } else {
                    fio.print(buyOrders.peek().price);
                }
                fio.print(" ");

                if (stockPrice == -1) {
                    fio.println("-");
                } else {
                    fio.println(stockPrice);
                }
            }
        }
        fio.close();
    }
}

class Order {
    int price;
    int shares;

    Order(int price, int shares) {
        this.price = price;
        this.shares = shares;
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

