package by.it.Shpakovskiy._tasks_.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> bean = Bean.class;
        Bean bn = bean.getDeclaredConstructor().newInstance();
        Method[] methods = bean.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Param.class)) {
                int a = method.getAnnotation(Param.class).a();
                int b = method.getAnnotation(Param.class).b();
                double res = (double) method.invoke(bn, a, b);
                System.out.println(method.getName() + ": " + res);
            }
        }
    }
}
