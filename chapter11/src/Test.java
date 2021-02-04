public class Test {
    @ClassPreamble( author = "홍길동"
                  , date   = "2021-02-01"
                  , member = {"이순신", "장보고"}
                  )
    public static void main(String[] args) {

    }


    @Deprecated
    public static void a(){

    }

    @interface ClassPreamble{
        String group() default "integer87";
        String author();
        String date();
        int revision() default 1;
        String[] member();
    }
}