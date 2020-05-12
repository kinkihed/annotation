package reflection;

public class Test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}

class A{
    static int m = 100;
    static {
        System.out.println("A的静态代码块");
        m = 300;
    }

    public  A(){
        System.out.println("A的无参构造器");
    }
}
