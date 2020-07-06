package by.it.romanshpakovskiy.tasks.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceManager {
    private static String path = "src/by/it/romanshpakovskiy/tasks/jd02_05/messages/messages.txt";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(path);
    private static Locale locale = Locale.getDefault();

    private ResourceManager(){}

    static String getKey(String key){
        return resourceBundle.getString(key);
    }

    static Locale getLocale(){
        return locale;
    }

    static void changeLocale(Locale loc){
        resourceBundle = ResourceBundle.getBundle(path, locale);
        locale = loc;
        Locale.setDefault(locale);
    }
}
