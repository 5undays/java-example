package reflection;

import reflection.data.Cosmetic;

import java.lang.reflect.Field;

public class Fields {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("reflection.data.Cosmetic");
        // public field
        Field field = c.getDeclaredField("name");
        System.out.println("find out name field in child : " + field);

        // all field
        Field field1[] = c.getDeclaredFields();
        for (Field f : field1) {
            System.out.println("get field in child : " + f);
        }

        // public field include extends
        Field field2[] = c.getFields();
        for (Field f : field2) {
            System.out.println("get field in both parent and child : " + f);
        }

        Cosmetic cosmetic = new Cosmetic();
        Field field3 = c.getField("name");
        System.out.println("cosmetic.name : " + field3.get(cosmetic));

        // field modify
        field3.set(cosmetic, "lip-stick");
        System.out.println("cosmetic.name : " + field3.get(cosmetic));

        // private field modify
        Field field4 = c.getDeclaredField("color");
        field4.setAccessible(true);
        field4.set(cosmetic, "orange");
        System.out.println("cosmetic.color : " + field4.get(cosmetic));

        // static field modify
        Field field5 = c.getDeclaredField("FACTORY");
        field5.set(null, "STORAGE_02");
        System.out.println("Cosmetic.FACTORY : " + field5.get(null));
    }
}
