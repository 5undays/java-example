package reflection.data;

public class Cosmetic extends Product {
    public String name = "eye-shadow";
    private String color = "brown";
    public static String FACTORY = "STORAGE_01";

    public static int getFactory(int number) {
        System.out.println("number " + number);
        return number;
    }

    public Cosmetic() {
    }

    private Cosmetic(String s) {
        this.name = s;
    }

    public int amount(int n) {
        System.out.println("amount : " + n);
        return n;
    }

    private int method5(int n) {
        System.out.println("method5 : " + n);
        return n;
    }
}
