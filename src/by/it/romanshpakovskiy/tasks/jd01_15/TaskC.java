package by.it.romanshpakovskiy.tasks.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TaskC {
    private static <T> void dir() {
        String path = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator;
        String clDir = TaskC.class.getName().replace(TaskC.class.getSimpleName(), "")
                .replace(".", File.separator);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try {
            terminal(scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void terminal(Scanner scanner) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(System.in))) {
            File currentDirectory = new File(System.getProperty("user.dir" +
                    "/src/by/it/Shpakovskiy/_tasks_/jd01_15"));
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("cd")) {
                    File parent = currentDirectory.getParentFile();
                    if (parent != null)
                        currentDirectory = parent;
                }
                if (command.equals("cd ..")) {
                    File newDirectory = new File(currentDirectory.toString() + "/" + command.substring(3));
                    if (newDirectory.isDirectory()) {
                        currentDirectory = newDirectory;
                    } else System.out.println("NO_SUCH_DIRECTORY");
                }
                if (command.equals("dir"))
                    dir();
                if (command.equals("end")) {
                    break;
                }
            }
        }
    }
}
