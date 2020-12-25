import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        String start = fio.nextLine();
        String end = fio.nextLine();

        HashMap<String, Integer> distances = new HashMap<>();
        distances.put(start, 0);
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(start, 0));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.icons.equals(end)) {
                fio.println(state.distance);
                break;
            }

            for (int i = 0; i < 8; i++) {
                String icons = state.icons;
                char icon = icons.charAt(i);
                StringBuilder newIcons = new StringBuilder();

                switch (icon) {
                    case 'A':
                        if (i >= 1) {
                            newIcons.append(icons.substring(0, i - 1));
                            newIcons.append(rotate(icons.charAt(i - 1)));
                        }
                        newIcons.append(icon);
                        if (i <= 6) {
                            newIcons.append(rotate(icons.charAt(i + 1)));
                            newIcons.append(icons.substring(i + 2));
                        }
                        break;

                    case 'B':
                        if (i >= 1 && i <= 6) {
                            newIcons.append(icons.substring(0, i + 1));
                            newIcons.append(icons.charAt(i - 1));
                            newIcons.append(icons.substring(i + 2));
                        } else {
                            newIcons.append(icons);
                        }
                        break;

                    case 'C':
                        int position = 7 - i;
                        newIcons.append(icons.substring(0, position));
                        newIcons.append(rotate(icons.charAt(position)));
                        newIcons.append(icons.substring(position + 1));
                        break;

                    case 'D':
                        if (i >= 1 && i <= 3) {
                            for (int j = 0; j < i; j++) {
                                newIcons.append(rotate(icons.charAt(j)));
                            }
                            newIcons.append(icons.substring(i));
                        } else if (i >= 4 && i <= 6) {
                            newIcons.append(icons.substring(0, i + 1));
                            for (int j = i + 1; j < 8; j++) {
                                newIcons.append(rotate(icons.charAt(j)));
                            }
                        } else {
                            newIcons.append(icons);
                        }
                        break;

                    case 'E':
                        if (i >= 1 && i <= 6) {
                            int difference = Math.min(i - 0, 7 - i);
                            int first = i - difference;
                            int second = i + difference;
                            newIcons.append(icons.substring(0, first));
                            newIcons.append(rotate(icons.charAt(first)));
                            newIcons.append(icons.substring(first + 1, second));
                            newIcons.append(rotate(icons.charAt(second)));
                            newIcons.append(icons.substring(second + 1));
                        } else {
                            newIcons.append(icons);
                        }
                        break;

                    case 'F':
                        if (i % 2 == 0) {
                            position = (i + 8) / 2;
                        } else {
                            position = i / 2;
                        }
                        newIcons.append(icons.substring(0, position));
                        newIcons.append(rotate(icons.charAt(position)));
                        newIcons.append(icons.substring(position + 1));
                        break;
                }

                String newIconsString = newIcons.toString();
                if (!distances.containsKey(newIconsString)) {
                    distances.put(newIconsString, state.distance + 1);
                    queue.offer(new State(newIconsString, state.distance + 1));
                } 
            }
        }

        fio.close();
    }

    private static char rotate(char icon) {
        return (char) (((icon - 'A' + 1) % 6) + 'A');
    }
}

class State {
    String icons;
    int distance;

    State(String icons, int distance) {
        this.icons = icons;
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

