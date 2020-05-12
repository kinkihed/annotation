package reflection;
//主动引用
public class Test06 {
    static {
        System.out.println("main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //1、主动引用
        //Son son = new Son();
        //2、反射也会引发主动引用
        //Class.forName("reflection.Son");

        //不会产生类的引用
        //1、子类访问父类的静态字段，只有父类被加载
        //System.out.println(Son.b);
        //数组子类父类都不会有加载
        //Son[] array = new Son[12];
        //静态常量不会加载类
        System.out.println(Son.M);
    }
}
class Father{
    static int b = 2;
    static{
        System.out.println("父类被加载");
    }
}
class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
    final int N = 3;
}