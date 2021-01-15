import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            // TODO 예외 처리할 구문

        }catch (NullPointerException e) {
            System.out.println("NullPointerException 발생했습니다.");

        }catch (ClassCastException e) {
            System.out.println("ClassCastException이 발생했습니다.");

        }catch (Exception e) {
            System.out.println("알수 없는 에러가 발생했습니다.");

        }finally {
            System.out.println("여기는 항상 실행됩니다.");
        }
        System.out.println("굿바이 ~");
    }
}
