import java.util.Random;
import java.util.concurrent.Semaphore;

class Filozof3 extends Thread {
    static int MAX = 5;
    static Semaphore[] widelec3 = new Semaphore[1000];
    int mojNum;
    Random losuj;

    public Filozof3(int nr) {
        mojNum = nr;
        losuj = new Random(mojNum);
    }

        public void run() {
                while (true) {
                        System.out.println("Mysle ¦ " + mojNum);
                try {
                        Thread.sleep((long) (5000 * Math.random()));
                } catch (InterruptedException e) {
                }

                int strona = losuj.nextInt(2);
                boolean podnioslDwaWidelce = false;

                do {
                if (strona == 0) {
                        widelec3[mojNum].acquireUninterruptibly();
                if (!(widelec3[(mojNum + 1) % MAX].tryAcquire())) {
                        widelec3[mojNum].release();
                } else {
                        podnioslDwaWidelce = true;
                }
                } else {
                        widelec3[(mojNum + 1) % MAX].acquireUninterruptibly();
                        if (!(widelec3[mojNum].tryAcquire())) {
                                widelec3[(mojNum + 1) % MAX].release();
                        } else {
                        podnioslDwaWidelce = true;
                        }
                }
                } while (podnioslDwaWidelce == false);
                        System.out.println("Zaczyna jesc " + mojNum);
                        try {
                                Thread.sleep((long) (3000 * Math.random()));
                        } catch (InterruptedException e) {
                        }

                System.out.println("Konczy jesc " + mojNum);
                widelec3[mojNum].release();
                widelec3[(mojNum + 1) % MAX].release();
                }
    }
}