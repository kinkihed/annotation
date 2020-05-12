package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态创建对象
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("reflection.User");
        //构造一个对象 ，弃用
        //User user = (User) c1.newInstance();  //调用无参构造器，没有无参构造器会报错

        //通过构造器创建对象
//        Constructor constructor = c1.getDeclaredConstructor(String.class,int.class,int.class);
//        User user2 = (User)constructor.newInstance("xiaoming",0,18) ;
//        System.out.println(user2);

        //通过反射调用方法
//        User user3 = (User) c1.newInstance();
//        Method setName = c1.getDeclaredMethod("setName", String.class);
//        //方法对象.invoke() 传入一个对象，和参数
//        setName.invoke(user3,"小明");
//        System.out.println(user3.getName());
//
        //修改字段值
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user4,"小军");
        System.out.println(user4.getName());

    }
}
