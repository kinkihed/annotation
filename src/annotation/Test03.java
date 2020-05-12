package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test03 {
    @MyAnnotation2(name = "小明")
    public void test(){
    }

    //使用时可以省略value
    @Myannotation3("")
    public void test2(){

    }
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数 ： 参数类型 + 参数名（） 定义默认值（如果没有使用时必须赋值）
    String name();
    int age() default 0;
    int id() default -1;  //默认值代表不存在
    String[] school() default {"厦门大学"};
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Myannotation3{
    //注解只有一个值，使用value
    String value();
}
