public class Test3 {
    public static void main(String[] args) {
        try{
            printHello("");

        }catch (NullPointerException e){
            System.out.println("please input id");

        }finally {
            System.out.println("Good Bye ~~");
        }
    }

    public static void printHello(String id) throws NullPointerException {
        if(id == null || id == ""){
            throw new NullPointerException();
        }else {
            System.out.println("Hello " + id);
        }
    }
}
