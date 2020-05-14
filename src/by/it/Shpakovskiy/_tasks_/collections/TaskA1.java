package by.it.Shpakovskiy._tasks_.collections;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class TaskA1 {
    public static void main(String[] args){
        Stack<String> stack = new Stack<>();
        try (Scanner scanner = new Scanner(new File("input.txt"));
             FileWriter fileWriter = new FileWriter(new File("output.txt"))){
            while(scanner.hasNextLine()){
                stack.push(scanner.nextLine());
            }
            for(int i = 0; i < stack.size() - 1; i++){
                fileWriter.write(stack.pop());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
