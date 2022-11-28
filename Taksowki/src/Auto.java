import java.util.Random;
public class Auto extends Thread {
    static int POSTOJ = 1;
    static int START = 2;
    static int KURS = 3;
    static int KONIEC_KURSU = 4;
    static int BRAK_PALIWA = 5;
    static int TANKUJ = 1000;
    static int REZERWA = 500;
    //zmienne pomocnicze
    int numer;
    int paliwo;
    int stan;
    Postoj l;
    Random rand;

    public Auto(int numer, int paliwo, Postoj l) {
        this.numer = numer;
        this.paliwo = paliwo;
        this.stan = KURS;
        this.l = l;
        rand = new Random();
    }

    public void run() {
        while (true) {
            if (stan == POSTOJ) {
                if (rand.nextInt(2) == 1) {
                    stan = START;
                    paliwo = TANKUJ;
                    System.out.println("Taksówka: " + numer + " rozpoczyna otrzymany kurs");
                    stan = l.start(numer);
                } else {
                    System.out.println("Czekam na kurs");
                }
            } else if (stan == START) {
                System.out.println("Taksowka nr: " + numer + " wyruszyła");
                stan = KURS;
            } else if (stan == KURS) {
                paliwo -= rand.nextInt(500);
                if (paliwo <= REZERWA) {
                    stan = KONIEC_KURSU;
                } else try {
                    sleep(rand.nextInt(1000));
                } catch (Exception e) {
                }
            } else if (stan == KONIEC_KURSU) {
                System.out.println("Auto nr: " + numer + " konczy kurs ");
                stan = l.koncz();
                if (stan == KONIEC_KURSU) {
                    paliwo -= rand.nextInt(500);
                    if (paliwo <= 0) stan = BRAK_PALIWA;
                }
            } else if (stan == BRAK_PALIWA) {
                System.out.println("Brak paliwa w aucie: " + numer);
                l.zmniejsz();
            }
        }
    }
}