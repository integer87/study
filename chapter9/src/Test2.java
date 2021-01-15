public class Test2 {
    public static void main(String[] args) {
        try{
            printHello(null);

        }catch (NullPointerException e){
            System.out.println("please input id");

        }finally {
            System.out.println("Good Bye ~~");
        }
    }

    public static void printHello(String id) throws NullPointerException {
        if(id.equals("A")){
            System.out.println("Hello A !!!");
        }else {
            System.out.println("Who are you?");
        }
    }
}
