import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;

public class Test {
    @ClassPreamble( author = "홍길동"
                  , date   = "2021-02-01"
                  , member = {"이순신", "장보고"}
                  )
    public static void main(String[] args) {

    }


    @FunctionalInterface
    public static void a(){

    }

    @Repeatable
    @interface ClassPreamble{
        String group() default "integer87";
        String author();
        String date();
        int revision() default 1;
        String[] member();
    }




}

class Car {
    private String name;
}
