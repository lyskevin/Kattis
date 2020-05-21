import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {

    private static int n;
    private static Story[] stories;
    private static int[] maximumRemainingAreas;
    private static LinkedList<Story> usedStories;
    private static int maximumArea;

    public static void main(String[] args) {
        FastIO fio = new FastIO();
        n = fio.nextInt();
        while (n > 0) {
            stories = new Story[n];
            int totalArea = 0;
            for (int i = 0; i < n; i++) {
                stories[i] = new Story(fio.nextInt(), fio.nextInt(), fio.nextInt(), fio.nextInt());
                totalArea += stories[i].getArea();
            }
            maximumRemainingAreas = new int[n];
            for (int i = 0; i < n; i++) {
                maximumRemainingAreas[i] = totalArea;
                totalArea -= stories[i].getArea();
            }
            usedStories = new LinkedList<>();
            maximumArea = 0;
            generateMaximumArea(0, 0);
            fio.println(maximumArea);
            n = fio.nextInt();
        }
        fio.close();
    }

    private static void generateMaximumArea(int index, int area) {
        if (index == n) {
            maximumArea = Math.max(maximumArea, area);
            return;
        }
        if (area + maximumRemainingAreas[index] < maximumArea) { // Prune here
            return;
        }
        Story story = stories[index];
        if (!hasOverlap(story)) { // Use current story if no overlap with all used stories
            usedStories.add(story);
            generateMaximumArea(index + 1, area + story.getArea());
            usedStories.removeLast();
        }
        generateMaximumArea(index + 1, area); // Do not use current story
    }

    private static boolean hasOverlap(Story story) {
        for (Story usedStory : usedStories) {
            if (usedStory.isOverlapping(story)) {
                return true;
            }
        }
        return false;
    }

}

class Story {

    int w;
    int h;
    int x;
    int y;

    Story(int w, int h, int x, int y) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
    }

    int getArea() {
        return w * h;
    }

    boolean isOverlapping(Story other) {
        Story firstStory = this.getFirstStory(other);
        Story secondStory = this == firstStory ? other : this;
        // Horizontal overlap
        if (firstStory.x <= secondStory.x && firstStory.x + firstStory.w > secondStory.x) {
            // Vertical overlap
            if (firstStory.y <= secondStory.y && firstStory.y + firstStory.h > secondStory.y
                    || secondStory.y <= firstStory.y && secondStory.y + secondStory.h > firstStory.y) {
                return true;
            }
        }
        return false;
    }

    Story getFirstStory(Story other) {
        if (this.x < other.x) {
            return this;
        } else if (this.x == other.x && this.y <= other.y) {
            return this;
        } else {
            return other;
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

