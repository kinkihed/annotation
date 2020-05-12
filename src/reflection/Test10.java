package reflection;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//性能分析
public class Test10 {
    //15ms
    public static void test01(){
        User user = new User();
        long startTime = System.currentTimeMillis();
        for(int i = 0;i< 100000000;i++){
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式时间"+(endTime - startTime)+"ms");
     }
    //反射方式执行效率狠低 855ms
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();

        Method getName = c1.getDeclaredMethod("getName",null);

        long startTime = System.currentTimeMillis();
        for(int i = 0;i< 100000000;i++){
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方式时间"+(endTime - startTime)+"ms");
    }
    //关闭检测可以提高效率 328ms
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();

        Method getName = c1.getDeclaredMethod("getName",null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for(int i = 0;i< 100000000;i++){
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("关闭检测方式时间"+(endTime - startTime)+"ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }
}
