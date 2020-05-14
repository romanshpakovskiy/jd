package by.it.romanshpakovskiy.tasks.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder stringBuilder = new StringBuilder();
            if (Modifier.isPublic(method.getModifiers())) {
                stringBuilder.append("public static ").append(method.getGenericReturnType()).append(" ")
                        .append(method.getName()).append("(");
                Parameter[] parameters = method.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    stringBuilder.append(parameters[i].getType().getName());
                    if(i != parameters.length - 1){
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append(")");
            }
            System.out.println(stringBuilder);
        }

        Field[] fields = structMath.getDeclaredFields();
        for (Field field : fields) {
            StringBuilder stringBuilder = new StringBuilder();
            if (Modifier.isPublic(field.getModifiers())) {
                stringBuilder.append("public static final ").append(field.getType().getName()).append(" ")
                .append(field.getName());
            }
            System.out.println(stringBuilder);



        }
    }
}
