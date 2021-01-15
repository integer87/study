public class Test5 {
    public static void main(String[] args) {
        try {
            printHello(null);
        } catch (NotAException e) {
            System.out.println("Who are you?");
        }
    }

    public static void printHello(String id) throws NotAException {
        if("A".equals(id)){
            System.out.println("Hello A !!!");
        }else {
            throw new NotAException("Not A Exception");
        }
    }
}

class NotAException extends Exception {
    public NotAException(String message){
        super(message);
    }
}
