package by.it.romanshpakovskiy.tasks.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskC {
    static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        String path = "src/by/it/Shpakovskiy/_tasks_";
        stringList = putFilesAndDirectoriesNamesAtList(path);
        stringList.forEach(System.out::println);
        try (PrintWriter printWriter = new PrintWriter(path + "/jd01_14/resultTaskC.txt")) {
            stringList.forEach(printWriter::println);
        }
    }

    static List<String> putFilesAndDirectoriesNamesAtList(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        List<String> list = new ArrayList<>();
        assert files != null;
        for (File f : files) {
            boolean flag=false;
            if (f.isDirectory()) {
                list.add("dir:" + f.getName());
                list.addAll(putFilesAndDirectoriesNamesAtList(f.toString()));
            } else list.add("file:" + f.getName());
        }
        return list;
    }
}
