package variable_casting;

public  class Testa {
    public static void main(String[] args) {
        test(4);
        new Object();
    }

    public static void test(Object args) {
        System.out.println(args);
    }
}
