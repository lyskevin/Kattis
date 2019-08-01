import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<>() {
            public int compare(Integer num1, Integer num2) {
                return -1 * num1.compareTo(num2);
            }
        };
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int numberOfInputs = sc.nextInt();
            sc.nextLine();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);
            boolean isStack = true;
            boolean isQueue = true;
            boolean isPQ = true;
            for (int i = 0; i < numberOfInputs; i++) {
                String[] commands = sc.nextLine().split(" ");
                Integer number = Integer.valueOf(Integer.parseInt(commands[1]));
                if (commands[0].equals("1")) {
                    stack.push(number);
                    queue.offer(number);
                    pq.offer(number);
                } else {
                    if (stack.empty() || !stack.pop().equals(number)) {
                        isStack = false;
                    }
                    if (queue.isEmpty() || !queue.poll().equals(number)) {
                        isQueue = false;
                    }
                    if (pq.isEmpty() || !pq.poll().equals(number)) {
                        isPQ = false;
                    }
                }
            }
            if (!isStack && !isQueue && !isPQ) {
                System.out.println("impossible");
            } else if (isStack && !isQueue && !isPQ) {
                System.out.println("stack");
            } else if (!isStack && isQueue && !isPQ) {
                System.out.println("queue");
            } else if (!isStack && !isQueue && isPQ) {
                System.out.println("priority queue");
            } else {
                System.out.println("not sure");
            }
        }
    }
}
