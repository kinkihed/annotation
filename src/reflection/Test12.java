package reflection;
//ORM 对象关系映射
//通过读取定义的注解，建立相应的数据库
//类名对应数据库名，字段对应表的列
//不同对象对应不同记录
import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("reflection.Student2");
        //获得注解
        Annotation[] annotations = c1.getAnnotations();
        for(Annotation annotation :annotations){
            System.out.println(annotation);
        }
        //获得注解的value值

        Table table = (Table)c1.getAnnotation(Table.class);
        table.value();

        Field f = c1.getDeclaredField("name");
        FieldT annotation = f.getAnnotation(FieldT.class);
        System.out.println(annotation.columName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());


    }
}


@Table("db_student")
class Student2{
    @FieldT(columName = "db_id",type = "int",length = 10)
    private int id;
    @FieldT(columName = "db_id",type = "int",length = 10)
    private int age;
    @FieldT(columName = "db_id",type = "varchar",length = 3)
    private String name;

    public Student2(){

    }
    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}
//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldT{
    String columName();
    String type();
    int length();
}