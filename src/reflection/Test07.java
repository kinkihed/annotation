package reflection;
//类加载器
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器 --》拓展类加载器
        ClassLoader extend = systemClassLoader.getParent();
        System.out.println(extend);

        //获取拓展类加载器的父类加载器 ==>引导类加载器
        ClassLoader root = extend.getParent();
        System.out.println(root);

        //当前类加载器
        ClassLoader cl = Class.forName("reflection.Test07").getClassLoader();
        System.out.println(cl);
//        //jdk内置类加载器，无法获取
//        ClassLoader cl2 = Class.forName("Java.lang.Object").getClassLoader();
//        System.out.println(cl2);
       //获取系统类加载器的可加载路径
        System.out.println(System.getProperty("java.class.path"));

    }
}
