package by.it.romanshpakovskiy.tasks.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.*;

public class Logger {
    private List<String> reportsList = new ArrayList<>();
    private static volatile Logger instance;
    private File file = new File(System.getProperty("user.dir"),
            "src/by/it/romanshpakovskiy/tasks/calc/log.txt");

    public static Logger getInstance() {
        Logger logger = instance;
        if (logger == null) {
            synchronized (Logger.class) {
                logger = instance;
                if (logger == null) {
                    logger = new Logger();
                    instance = logger;
                }
            }
        }
        return logger;
    }

    public static void setInstance(Logger instance) {
        Logger.instance = instance;
    }

    synchronized void printLog(String report) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            String date = dateFormat.format(new Date());
            printWriter.println(report + "    " + date);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
