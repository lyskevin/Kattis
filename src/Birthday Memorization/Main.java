import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        Comparator<Friend> nameComparator = (x, y) -> x.name.compareTo(y.name);

        int N = fio.nextInt();
        HashMap<String, Friend> friends = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = fio.next();
            int preference = fio.nextInt();
            String birthday = fio.next();

            if (!friends.containsKey(birthday) || friends.get(birthday).preference < preference) {
                friends.put(birthday, new Friend(name, preference, birthday));
            }
        }

        Friend[] sortedFriends = new Friend[friends.size()];
        int index = 0;
        for (Friend friend : friends.values()) {
            sortedFriends[index++] = friend;
        }

        Arrays.sort(sortedFriends, nameComparator);

        fio.println(friends.size());
        for (Friend friend : sortedFriends) {
            fio.println(friend.name);
        }

        fio.close();
    }
}

class Friend {
    String name;
    int preference;
    String birthday;

    Friend(String name, int preference, String birthday) {
        this.name = name;
        this.preference = preference;
        this.birthday = birthday;
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

