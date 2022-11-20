import java.util.concurrent.Semaphore;

class Filozof1 extends Thread {
    static int MAX = 5;
    static Semaphore[] widelec1 = new Semaphore[1000];
    int mojNum;

    public Filozof1(int nr) {
        mojNum = nr;
    }
}