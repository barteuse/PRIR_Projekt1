import java.util.concurrent.Semaphore;

class Filozof2 extends Thread {
    static int MAX = 5;
    static Semaphore[] widelec2 = new Semaphore[1000];
    int mojNum;

    public Filozof2(int nr) {
        mojNum = nr;
    }
}