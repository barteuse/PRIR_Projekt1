import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz wariant programu");
        int wariant = scanner.nextInt();

        System.out.println("Podaj ilosc filozofow");
        int ilosc = scanner.nextInt();

        Filozof1.MAX = ilosc;
        Filozof2.MAX = ilosc;
        Filozof3.MAX = ilosc;

        switch (wariant){
            case 1: {
                for (int i = 0; i < Filozof1.MAX; i++) {
                    Filozof1.widelec1[i] = new Semaphore(1);
                }
                for (int i = 0; i < Filozof1.MAX; i++) {
                    new Filozof1(i).start();
                }
            }
            case 2: {
                for (int i = 0; i < Filozof2.MAX; i++) {
                    Filozof2.widelec2[i] = new Semaphore(1);
                }
                for (int i = 0; i < Filozof2.MAX;  i++) {
                    new Filozof2(i).start();
                }
            }
            case 3: {
                for ( int i =0; i<Filozof3.MAX;  i++) {
                    Filozof3.widelec3 [ i ]=new Semaphore ( 1 ) ;
                }
                for ( int i =0; i<Filozof3.MAX;  i++) {
                    new Filozof3(i).start();
                }
            }
        }
    }
}