package by.it.Shpakovskiy._tasks_.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class TaskA2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Stack<String> stack = new Stack<>();
        String[] string = Integer.toString(number).trim().split("");
        for (int i = 0; i < string.length - 1; i++) {
            stack.push(string[i]);
        }

        for (int i = 0; i < stack.size() - 1; i++) {
            stack.pop();
        }
        System.out.println(stack);
    }
}
