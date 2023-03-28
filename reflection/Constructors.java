package reflection;

import java.lang.reflect.Constructor;

public class Constructors {
    public static void main(String[] args) throws Exception {
        // 클래스를 상속 받아 가져오기
//        Class c1 = Cosmetic.class;
//        System.out.println("Class Name : " + c1.getName());

        // 클래스의 이름으로 클래스 정보 가져오기
        Class c = Class.forName("reflection.data.Cosmetic");
        System.out.println("c Class name : " + c.getName());

        // reflection.Constructor 가져오기
        Constructor constructor = c.getDeclaredConstructor();
        System.out.println("c reflection.Constructor : " + constructor.getName());

        // 모든 reflection.Constructor 가져오기
        Constructor constructor1[] = c.getDeclaredConstructors();
        for (Constructor con : constructor1) {
            System.out.println("get constructors in child : " + con);
        }

        // only public contructor
        Constructor constructor2[] = c.getConstructors();
        for (Constructor con : constructor2) {
            System.out.println("get public constructors in child : " + con);
        }


    }
}
