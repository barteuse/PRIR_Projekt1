import java.util.Random;

public class MonteCarlo {

    static class Monte_Carlo extends Thread {
        int precyzja;
        double x, y, pi = 0;
        int hit = 0, total = 0;
        Random rand = new Random();

        Monte_Carlo(int precyzja) {
            this.precyzja = precyzja;
        }

        public void run () {
            for (int i = 0; i < precyzja; i++) {
                x = rand.nextDouble();
                y = rand.nextDouble();
                if (Math.pow(x,2) + Math.pow(y,2) <= 1){
                    hit++;
                }
                total++;

                pi = (double)(4 * hit) / total;
            }
        }
    }

    public static void main (String [] args) {
        Monte_Carlo m1 = new Monte_Carlo (1000);
        Monte_Carlo m2 = new Monte_Carlo (10000);
        Monte_Carlo m3 = new Monte_Carlo (1000000);
        m1.start ();
        m2.start ();
        m3.start ();
        try {
            m1.join ();
            m2.join ();
            m3.join ();
        } catch (InterruptedException e) {
        }

        System.out.println ("Wynik dla precyzji " + m1.precyzja + " pi = " + m1.pi);
        System.out.println ("Wynik dla precyzji " + m2.precyzja + " pi = " + m2.pi);
        System.out.println ("Wynik dla precyzji " + m3.precyzja + " pi = " + m3.pi);

    }
}