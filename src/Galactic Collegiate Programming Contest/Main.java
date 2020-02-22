import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*;
import java.lang.StringBuilder;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int numberOfTeams = fr.nextInt();
        int numberOfEvents = fr.nextInt();
        HashMap<Integer, Score> teams = new HashMap<>();
        AvlTree scores = new AvlTree();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numberOfTeams; i++) {
            Score score = new Score(0, 0);
            teams.put(i + 1, score);
            scores.insert(score);
        }
        for (int i = 0; i < numberOfEvents; i++) {
            int team = fr.nextInt();
            int penalty = fr.nextInt();
            Score score = teams.get(team);
            scores.delete(score);
            Score newScore = new Score(score.numberOfSolvedProblems + 1,
                    score.totalPenalty + penalty);
            scores.insert(newScore);
            teams.put(team, newScore);
            output.append(scores.getRank(teams.get(1)));
            output.append("\n");
        }
        System.out.print(output);
    }
}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
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

class Score implements Comparable<Score> {

    int numberOfSolvedProblems;
    int totalPenalty;

    Score(int numberOfSolvedProblems, int totalPenalty) {
        this.numberOfSolvedProblems = numberOfSolvedProblems;
        this.totalPenalty = totalPenalty;
    }

    @Override
        public int compareTo(Score other) {
            if (this.numberOfSolvedProblems != other.numberOfSolvedProblems) {
                return other.numberOfSolvedProblems - this.numberOfSolvedProblems;
            } else {
                return this.totalPenalty - other.totalPenalty;
            }
        }

    @Override
        public boolean equals(Object other) {
            return this.compareTo((Score) other) == 0;
        }

    @Override
        public String toString() {
            return String.format("(%d, %d)", numberOfSolvedProblems, totalPenalty);
        }

}

class TreeNode {

    TreeNode parent, left, right;
    Score key;
    int keyCount;
    int height;
    int size;

    TreeNode(Score s) {
        key = new Score(s.numberOfSolvedProblems, s.totalPenalty);
        keyCount = 1;
        parent = left = right = null;
        height = 0;
        size = 0;
    }

    @Override
        public String toString() {
            return "(" + key.toString() + ", " + size + ")";
        }

}

class AvlTree {

    TreeNode root;

    AvlTree() {
        root = null;
    }

    Score search(Score s) {
        TreeNode result = search(root, s);
        return result == null ? null : result.key;
    }

    private TreeNode search(TreeNode t, Score s) {
        if (t == null) return null;    // not found
        else if (t.key.equals(s)) return t;    // found
        else if (t.key.compareTo(s) < 0) return search(t.right, s);    // search to the right
        else return search(t.left, s);    // search to the left
    }

    TreeNode findMin() {
        return findMin(root);
    }

    private TreeNode findMin(TreeNode t) {
        if (t.left == null) return t;    // min found
        else return findMin(t.left);    // search to the left
    }

    TreeNode findMax() {
        return findMax(root);
    }

    private TreeNode findMax(TreeNode t) {
        if (t.right == null) return t;    // max found
        else return findMax(t.right);    // search to the right
    }

    TreeNode successor(Score s) {
        TreeNode t = search(root, s);
        return t == null ? null : successor(t);
    }

    private TreeNode successor(TreeNode t) {
        if (t.right != null) {
            return findMin(t.right);    // successor is min of right subtree
        }
        else {
            TreeNode parent = t.parent;
            TreeNode current = t;
            while ((parent != null) && (current.key.equals(parent.right.key))) {
                current = parent;    // move up until successor is found
                parent = current.parent;
            }
            return parent == null ? null : parent;
        }
    }

    TreeNode predecessor(Score s) {
        TreeNode t = search(root, s);
        return t == null ? null : predecessor(t);
    }

    private TreeNode predecessor(TreeNode t) {
        if (t.left != null) {
            return findMax(t.left);    // predecessor is max of left subtree
        } else {
            TreeNode parent = t.parent;
            TreeNode current = t;
            while ((parent != null) && (current.key.equals(parent.left.key))) {
                current = parent;
                parent = current.parent;
            }
            return parent == null ? null : parent;
        }
    }

    void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(TreeNode t) {
        if (t == null) return;
        inorder(t.left);
        System.out.printf(" %s", t.key.toString());
        inorder(t.right);
    }

    void insert(Score s) {
        root = insert(root, s);
    }

    private TreeNode insert(TreeNode t, Score s) {

        if (t == null) {
            t = new TreeNode(s);    // insertion point found
        } else if (t.key.equals(s)) {
            t.keyCount += 1;    // duplicate score
        } else if (t.key.compareTo(s) < 0) {
            t.right = insert(t.right, s);    // insert into right subtree
            t.right.parent = t;
        } else {
            t.left = insert(t.left, s);    // insert into left subtree
            t.left.parent = t;
        }

        // increase height along insertion path
        t.height = Math.max(getHeight(t.left), getHeight(t.right)) + 1;

        // perform rotations if necessary
        int balanceFactor = balanceFactor(t);
        if (balanceFactor == 2) {
            if (balanceFactor(t.left) >= 0 && balanceFactor(t.left) <= 1) { // ll rotation
                t = rotateRight(t);
            } else if (balanceFactor(t.left) == -1) { // lr rotation
                t.left = rotateLeft(t.left);
                t = rotateRight(t);
            }
        } else if (balanceFactor == -2) {
            if (balanceFactor(t.right) <= 0 && balanceFactor(t.right) >= -1) { // rr rotation
                t = rotateLeft(t);
            } else if (balanceFactor(t.right) == 1) { // rl rotation
                t.right = rotateRight(t.right);
                t = rotateLeft(t);
            }
        }

        // update size attribute
        t.size = getSize(t.left) + getSize(t.right) + t.keyCount;

        return t;

    }

    private int balanceFactor(TreeNode t) {
        return getHeight(t.left) - getHeight(t.right);
    }

    void delete(Score s) {
        root = delete(root, s);
    }

    private TreeNode delete(TreeNode t, Score s) {

        if (t == null) { // cannot find score to be deleted
            return t;
        } else if (t.key.equals(s)) { // duplicate score found
            if (t.keyCount > 1) {
                t.keyCount -= 1;
            } else {
                if (t.left == null && t.right == null) { // no children
                    t = null;
                    return t;
                } else if (t.left == null && t.right != null) { // only right child
                    t.right.parent = t.parent;
                    t = t.right;
                } else if (t.left != null && t.right == null) { // only left child
                    t.left.parent = t.parent;
                    t = t.left;
                } else { // two children; find successor
                    TreeNode successor = successor(s);
                    t.key = new Score(successor.key.numberOfSolvedProblems,
                            successor.key.totalPenalty);
                    t.keyCount = successor.keyCount;
                    if (successor.keyCount > 1) successor.keyCount = 1;
                    t.right = delete(t.right, successor.key);
                }
            }
        } else if (t.key.compareTo(s) < 0) { // search to the right
            t.right = delete(t.right, s);
        } else {  // search to the left
            t.left = delete(t.left, s);
        }

        if (t != null) {

            // update height along deletion path
            t.height = Math.max(getHeight(t.left), getHeight(t.right)) + 1;

            // perform rotations if necessary
            int balanceFactor = balanceFactor(t);
            if (balanceFactor == 2) {
                if (balanceFactor(t.left) >= 0 && balanceFactor(t.left) <= 1) { // ll rotation
                    t = rotateRight(t);
                } else if (balanceFactor(t.left) == -1) { // lr rotation
                    t.left = rotateLeft(t.left);
                    t = rotateRight(t);
                }
            } else if (balanceFactor == -2) {
                if (balanceFactor(t.right) <= 0 && balanceFactor(t.right) >= -1) { // rr rotation
                    t = rotateLeft(t);
                } else if (balanceFactor(t.right) == 1) { // rl rotation
                    t.right = rotateRight(t.right);
                    t = rotateLeft(t);
                }
            }

            // update size attribute
            t.size = getSize(t.left) + getSize(t.right) + t.keyCount;
        }

        return t;    // return the updated tree

    }

    int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode t) {
        if (t == null) return -1;
        else return t.height;
    }

    private TreeNode rotateLeft(TreeNode t) {
        TreeNode w = t.right;
        w.parent = t.parent;
        t.parent = w;
        t.right = w.left;
        if (w.left != null) w.left.parent = t;
        w.left = t;
        t.height -= 1;
        w.height += 1;
        t.size = getSize(t.left) + getSize(t.right) + t.keyCount;
        w.size = getSize(w.left) + getSize(w.right) + t.keyCount;
        return w;
    }

    private TreeNode rotateRight(TreeNode t) {
        TreeNode w = t.left;
        w.parent = t.parent;
        t.parent = w;
        t.left = w.right;
        if (w.right != null) w.right.parent = t;
        w.right = t;
        t.height -= 1;
        w.height += 1;
        t.size = getSize(t.left) + getSize(t.right) + t.keyCount;
        w.size = getSize(w.left) + getSize(w.right) + t.keyCount;
        return w;
    }

    private int getSize(TreeNode t) {
        if (t == null) return 0;
        else return t.size;
    }

    int getRank(Score s) {
        return getRank(s, root, 0);
    }

    private int getRank(Score s, TreeNode t, int carry) {
        if (t == null) {
            return -1;
        } else if (t.key.equals(s)) {
            return carry + getSize(t.left) + 1;
        } else if (t.key.compareTo(s) > 0) {
            return getRank(s, t.left, carry);
        } else {
            return getRank(s, t.right, carry + getSize(t.left) + t.keyCount);
        }
    }

}

