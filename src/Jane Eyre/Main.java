import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        int m = fio.nextInt();
        int k = fio.nextInt();

        PriorityQueue<Book> books = new PriorityQueue<>();
        books.offer(new Book("\"Jane Eyre\"", k));

        for (int i = 0; i < n; i++) {
            String[] input = fio.nextLine().split(" ");
            StringBuilder title = new StringBuilder();
            for (int j = 0; j < input.length - 1; j++) {
                if (j > 0) {
                    title.append(" ");
                }
                title.append(input[j]);
            }
            books.offer(new Book(title.toString(), Integer.parseInt(input[input.length - 1])));
        }

        ScheduledBook[] scheduledBooks = new ScheduledBook[m];
        for (int i = 0; i < m; i++) {
            String[] input = fio.nextLine().split(" ");
            StringBuilder title = new StringBuilder();
            for (int j = 1; j < input.length - 1; j++) {
                if (j > 1) {
                    title.append(" ");
                }
                title.append(input[j]);
            }
            scheduledBooks[i] = new ScheduledBook(Integer.parseInt(input[0]),
                    new Book(title.toString(), Integer.parseInt(input[input.length - 1])));
        }
        Arrays.sort(scheduledBooks);

        long time = 0l;
        int scheduledBooksIndex = 0;
        while (scheduledBooksIndex < m && scheduledBooks[scheduledBooksIndex].time <= time) {
            books.offer(scheduledBooks[scheduledBooksIndex].book);
            scheduledBooksIndex++;
        }

        while (!books.peek().title.equals("\"Jane Eyre\"")) {
            Book book = books.poll();
            time += book.pages;
            while (scheduledBooksIndex < m && scheduledBooks[scheduledBooksIndex].time <= time) {
                books.offer(scheduledBooks[scheduledBooksIndex].book);
                scheduledBooksIndex++;
            }
        }

        fio.println(time + k);

        fio.close();
    }
}

class Book implements Comparable<Book> {
    String title;
    int pages;

    Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    @Override
        public int compareTo(Book other) {
            return this.title.compareTo(other.title);
        }
}

class ScheduledBook implements Comparable<ScheduledBook> {
    int time;
    Book book;

    ScheduledBook(int time, Book book) {
        this.time = time;
        this.book = book;
    }

    @Override
        public int compareTo(ScheduledBook other) {
            return this.time - other.time;
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

