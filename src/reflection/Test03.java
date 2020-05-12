package reflection;
//测试Class创建返方式
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是" + person.name);
        //方式1 通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());
        //方式2  forName（）完整类名获得
        Class c2 = Class.forName("reflection.Student");
        System.out.println(c2.hashCode());
        //方式3 类名.class 获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());
        //方式4 包装类的TYPE属性
        Class<Integer> c4 = Integer.TYPE;
        System.out.println(c4);

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person{
    public String name;

    public Person(){}

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}