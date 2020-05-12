package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflection.User");

//        User user = new User();
//        c1 = user.getClass();
        //获取类名
        System.out.println( c1.getName() );
        System.out.println(c1.getSimpleName());

        //获得类属性
        System.out.println("=======获得类属性============");
        Field[] fields = c1.getFields();  //找到public属性

        fields = c1.getDeclaredFields(); //找到所有属性
        for(Field f : fields){
            System.out.println(f);
        }
        Field name = c1.getDeclaredField("name");  //指定属性
        System.out.println(name);


        System.out.println("===========获得类方法==============");
        Method[] methods = c1.getMethods();  //本类的和父类的public
        for(Method m :methods){
            System.out.println("本类的和父类的  "+m);
        }

        Method[] methods2 = c1.getDeclaredMethods();//本类的所有方法包括私有
        for(Method m :methods2){
            System.out.println("本类的  "+m);
        }

        Method getName = c1.getMethod("getName",null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        System.out.println("===========获得构造器==============");
        Constructor[] constructors = c1.getConstructors();
        Constructor[] constructors1 = c1.getDeclaredConstructors();

    }
}
