
/**
 * Created by manojpolisetti on 27/10/15.
 */
public class Divider implements Runnable {
    public static int counter = 0;

    private static class Thread1 implements Runnable {
        int start;
        int end;

        public Thread1(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = this.start; i <= this.end; i++) {
                if (i % 7 == 0) {
                    counter++;
                }
            }
        }
    }
    private static class Thread2 implements Runnable {
        int start;
        int end;


        public Thread2(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = this.start; i <= this.end; i++) {
                if (i % 7 == 0) {
                    counter++;
                }
            }
        }
    }

    private static class Thread3 implements Runnable {
        int start;
        int end;

        public Thread3(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = this.start; i <= this.end; i++) {
                if (i % 7 == 0) {
                    counter++;
                }
            }
        }
    }
    public int get() {
        return counter;
    }

    public void run() {

    }

    public static void main(String[] args) {
        Divider divider = new Divider();
        Thread t1 = new Thread(new Thread1(1, 1000));
        Thread t2= new Thread(new Thread2(1001, 2000));
        Thread t3 = new Thread(new Thread3(2001, 3000));

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        }
        catch (InterruptedException e) {
            System.out.println("Big Problem");
        }
        System.out.println(divider.get());
    }
}
