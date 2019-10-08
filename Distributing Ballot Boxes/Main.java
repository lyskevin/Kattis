import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        int b = fio.nextInt();
        while (n != -1 || b != -1) {
            PriorityQueue<City> pq = new PriorityQueue<>();
            long totalPopulation = 0;
            for (int i = 0; i < n; i++) {
                long population = fio.nextLong();
                City city = new City(population);
                pq.offer(city);
                totalPopulation += population;
            }
            long numberOfBoxes = b - n;
            while (numberOfBoxes > 0) {
                City city = pq.poll();
                if (city.hasAddedBoxes) {
                    city.numberOfBoxes += 1;
                    numberOfBoxes -= 1;
                    pq.offer(city);
                } else {
                    long numberOfBoxesRequired =
                        numberOfBoxes * city.getMaxPeoplePerBox() / totalPopulation;
                    if (numberOfBoxesRequired == 0) {
                        numberOfBoxesRequired = 1;
                    }
                    city.numberOfBoxes = city.numberOfBoxes + numberOfBoxesRequired;
                    city.hasAddedBoxes = true;
                    numberOfBoxes -= numberOfBoxesRequired;
                    totalPopulation -= (city.population - city.getMaxPeoplePerBox());
                    pq.offer(city);
                }
            }
            fio.println(pq.peek().getMaxPeoplePerBox());
            n = fio.nextInt();
            b = fio.nextInt();
        }
        fio.close();
    }
}

class City implements Comparable<City> {

    long population;
    long numberOfBoxes;
    boolean hasAddedBoxes;

    City(long population) {
        this.population = population;
        numberOfBoxes = 1;
        hasAddedBoxes = false;
    }

    public int getMaxPeoplePerBox() {
        if (population % numberOfBoxes == 0) {
            return (int) (population / numberOfBoxes);
        } else {
            return (int) ((population / numberOfBoxes) + 1);
        }
    }

    @Override
        public int compareTo(City other) {
            return other.getMaxPeoplePerBox() - this.getMaxPeoplePerBox();
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

