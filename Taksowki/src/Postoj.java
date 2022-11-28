public class Postoj {
    static int LOTNISKO=1;
    static int START=2;
    static int KONIEC_kursu=4;
    int ilosc_miejscpostojowych;
    int ilosc_zajetych;
    int ilosc_aut;
    Postoj(int ilosc_pasow, int ilosc_aut){
        this.ilosc_miejscpostojowych=ilosc_pasow;
        this.ilosc_aut=ilosc_aut;
        this.ilosc_zajetych=0;
    }
    synchronized int start(int numer){
        ilosc_zajetych--;
        System.out.println("Auto numer "+ numer + "moze jechac");
        return START;
    }
    synchronized int koncz(){
        try{
            Thread.currentThread().sleep(1000);//sleep for 1000 ms
        }
        catch(Exception ie){
        }
        if(ilosc_zajetych<ilosc_miejscpostojowych){
            ilosc_zajetych++;
            System.out.println("Mozliwosc postoju na "+ilosc_zajetych);
            return LOTNISKO;
        }
        else
        {return KONIEC_kursu;}
    }
    synchronized void zmniejsz(){
        ilosc_aut--;
        System.out.println("Kraksa");
        if(ilosc_aut==ilosc_miejscpostojowych) System.out.println("ILOSC AUT TAKA SAMA JAK ILOSC MIEJSC POSTOJOWYCH");
    }
}
