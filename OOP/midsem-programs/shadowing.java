class Outer {
    static int a = 10;

    class Inner {
        int a = 20;
        void call() {
            System.out.println(a);
            System.out.println(Outer.a);
        }
    }
}

public class shadowing {
    public static void main(String[] args) {
        Outer objo = new Outer();
        Outer.Inner obj2 = objo.new Inner();
        obj2.call();
    }
}
