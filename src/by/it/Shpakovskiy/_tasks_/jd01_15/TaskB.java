package by.it.Shpakovskiy._tasks_.jd01_15;

import java.io.*;

public class TaskB {
    private static boolean delComment = false;

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Class<TaskB> taskBClass = TaskB.class;
        String s = stringBuilder.toString();
        s = deleteCommentsWhileReadingClass(taskBClass);
        writeProgramToFile(taskBClass);
    }

    private static String dir(String s, Class<?> cl){
        String path = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(),"")
                .replace(".", File.separator);
        return path + clDir;
    }

    private static String deleteCommentsWhileReadingClass(Class<TaskB> taskBClass) {
        String string = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                dir(taskBClass.getSimpleName() + ".java", taskBClass)))) {
            while((string = bufferedReader.readLine())!=null){
                if(!delComment){
                    bufferedReader.readLine();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    private static void deleteComments(String str) throws IOException {
        if (str.contains("/")) {
            int open = str.indexOf("/") + 1;
            char c = str.charAt(open + 1);
            if (c == '*') {
                while(!str.equals("\\")) {
                    delComment = false;
                }
            }
            if (c == '/') {
                str.substring(open);
                delComment = false;
            }
        }
    }




    private static void writeProgramToFile(Class<TaskB> taskBClass){
        try(PrintWriter writer = new PrintWriter(new FileWriter(
                dir(taskBClass.getSimpleName() + ".txt", taskBClass)))) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

