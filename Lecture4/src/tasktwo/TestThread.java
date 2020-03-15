package tasktwo;

public class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println("I am a thread, suck my cock!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void keks(String str) {
        for (int i = 0; i < 5; i++) {
            System.out.println(str);
        }
    }
    public static void main(String[] args) {

        TestThread tt = new TestThread();
        tt.start();
        try {
            tt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        keks("hahahahha");



    }
}
