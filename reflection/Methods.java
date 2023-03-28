package reflection;

import reflection.data.Cosmetic;

import java.lang.reflect.Method;

public class Methods {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("reflection.data.Cosmetic");

        // find method
        Method method = c.getDeclaredMethod("amount", int.class);
        System.out.println("find out method4 method in child : " + method);

        // find method error
        // Method method1 =c.getDeclaredMethod("method4", null);

        // parameter type array
        Class param[] = new Class[1];
        param[0] = int.class;
        Method method1 = c.getDeclaredMethod("amount", param);

        // method iter
        Method method2[] = c.getDeclaredMethods();
        for (java.lang.reflect.Method m : method2) {
            System.out.println("get method in child : " + m);
        }

        // iter method include extends
        Method method3[] = c.getMethods();
        for (java.lang.reflect.Method m : method3) {
            System.out.println("get public methods in both parent and child : " + m);
        }

        // invoke result
        Cosmetic cosmetic = new Cosmetic();
        Method method4 = c.getDeclaredMethod("amount", int.class);
        int result = (int) method.invoke(cosmetic, 10);
        System.out.println("result value : " + result);

        // Parent get method error - (no private)
        Class c2 = Class.forName("reflection.data.Product");
//        Method method5 = c2.getDeclaredMethod("method1");
//        method.invoke(cosmetic);

        // access modifier modify
        Method method6 = c2.getDeclaredMethod("method1");
        method6.setAccessible(true);
        method6.invoke(cosmetic);

        // static method modify
        Method method5 = c.getDeclaredMethod("getFactory", int.class);
        method5.invoke(null, 2);
    }
}
