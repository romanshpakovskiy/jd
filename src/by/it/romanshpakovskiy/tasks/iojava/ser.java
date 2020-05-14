package by.it.romanshpakovskiy.tasks.iojava;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ser {
    public static void main(String[] args) {
        String path = "src/by/it/Shpakovskiy/_tasks_/iojava/obj.object";
    }

    static boolean serialization(Man man, String path){
        File objFile = new File(path);
        boolean flag = false;
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objFile));
            oos.writeObject(man);
            flag = true;
        } catch (IOException e){
            e.printStackTrace();
        }
        return flag;
    }
}
