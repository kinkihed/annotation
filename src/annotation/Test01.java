package annotation;

public class Test01 {
    @Override
    public String toString() {
        return super.toString();
    }
    @Deprecated
    public void test(){
        System.out.println("@Deprecated");
    }

    public static void main(String[] args) {
        Test01 ts = new Test01();
        ts.test();
    }

}
