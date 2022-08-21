import java.util.ArrayDeque;
import java.util.Scanner;

public class Attempt_01_Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        ArrayDeque<Integer> task = new ArrayDeque<>();
        ArrayDeque<Integer>thread = new ArrayDeque<>();

        String[]input1 = scanner.nextLine().split(", ");
        for (int i = 0; i < input1.length; i++) {
            task.push(Integer.parseInt(input1[i]));
        }
        String[]input2 = scanner.nextLine().split(" ");
        for (int i = 0; i < input2.length; i++) {
            thread.offer(Integer.parseInt(input2[i]));
        }
        int taskToKill = Integer.parseInt(scanner.nextLine());
        int taskKiller = 0;
        while (true){
            if (task.peek() == taskToKill){
                taskKiller = thread.peek();
                break;
            }

            if (thread.peek() >= task.peek()){
                thread.poll();
                task.pop();
            }
            else if (thread.peek() < task.peek()){
                thread.poll();
            }

        }
        System.out.printf("Thread with value %d killed task %d%n",taskKiller,taskToKill);
        System.out.println(thread.toString().replaceAll("[\\[\\],]",""));

    }
}
