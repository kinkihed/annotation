package reflection;
//什么叫反射
public class Test01 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        //获得Class对象
        //一个类的Class对象是唯一的
        //它的整个类结构被封装在其中
        Class c1 = Class.forName("reflection.User");
        System.out.println(c1);

        Class c2 = Class.forName("reflection.User");
        //
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}
//实体类  pojo ,entity
class User{
    private String name;
    private int id;
    private int age;
    public User(){}
    public User(String name,int id,int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    private void test(){

    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}