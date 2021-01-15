public class Test6 {
    public static void main(String[] args) {
        printHello(null);

    }

    public static void printHello(String id) throws NotAException2 {
        if("A".equals(id)){
            System.out.println("Hello A !!!");
        }else {
            throw new NotAException2("Not A Exception");
        }
    }
}

class NotAException2 extends RuntimeException {
    public NotAException2(String message){
        super(message);
    }
}
