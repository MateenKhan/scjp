package variable_casting;

public class Main {
    public static void main(String[] args) {

        testUpcastingArgument(new Child());
//        testDowncastingArgument(new Parent());
    }

    public static void testUpcastingArgument(Parent p) {
        System.out.println(p.name);
        System.out.println(((Child)p).name);
    }

    public static void testDowncastingArgument(Child p) {

    }
}

class Parent{
    String name ="parent";
    void test(){
        System.out.println(name);
    }
}
class Child extends Parent{
    String name ="child";
    void test(){
        System.out.println(name);
    }
}
