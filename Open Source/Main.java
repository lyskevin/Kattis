import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            String projectName = fio.nextLine();
            if (projectName.equals("0")) {
                break;
            }
            HashMap<String, Project> projects = new HashMap<>();
            HashMap<String, String> userIDMappings = new HashMap<>();
            HashSet<String> usedUserIDs = new HashSet<>();
            while (!projectName.equals("1")) {
                String input = fio.nextLine();
                projects.put(projectName, new Project(projectName));
                while (Character.isLowerCase(input.charAt(0))) {
                    if (!usedUserIDs.contains(input)) {
                        if (userIDMappings.containsKey(input)) {
                            String otherProjectName = userIDMappings.get(input);
                            if (!otherProjectName.equals(projectName)) {
                                projects.get(otherProjectName).users.remove(input);
                                usedUserIDs.add(input);
                            }
                        } else {
                            userIDMappings.put(input, projectName);
                            projects.get(projectName).users.add(input);
                        }
                    }
                    input = fio.nextLine();
                }
                projectName = input;
            }
            ArrayList<Project> projectList = new ArrayList<>();
            for (Project project : projects.values()) {
                projectList.add(project);
            }
            Collections.sort(projectList);
            for (Project project : projectList) {
                fio.println(project);
            }
        }
        fio.close();
    }
}

class Project implements Comparable<Project> {

    String name;
    HashSet<String> users;

    Project(String name) {
        this.name = name;
        users = new HashSet<>();
    }

    public int compareTo(Project other) {
        if (!(this.users.size() == other.users.size())) {
            return other.users.size() - this.users.size();
        } else {
            return this.name.compareTo(other.name);
        }
    }

    public String toString() {
        return name + " " + users.size();
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

