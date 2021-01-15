public class Test4 {
    public static void main(String[] args) {
        printHello(null);
    }

    public static void printHello(String id){
        /*
        if(id.equals("A")){
            System.out.println("Hello A !!!");
        }else {
            System.out.println("Who are you?");
        }
        */

        if("A".equals(id)){
            System.out.println("Hello A !!!");
        }else {
            System.out.println("Who are you?");
        }
    }
}
