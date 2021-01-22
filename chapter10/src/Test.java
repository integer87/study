public class Test{
    public static void main(String[] args) {
        int count = 0;

        Thread th1 = new IncrementThread(count);
        Thread th2 = new PrintThread(count);

        th1.start();
        th2.start();
    }
}



class IncrementThread extends Thread {
    private int count = 0;

    public IncrementThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            count++;
        }
    }
}

class PrintThread extends Thread {
    private int count = 0;

    public PrintThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(count);
    }
}

