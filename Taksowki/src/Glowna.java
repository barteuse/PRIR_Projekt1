public class Glowna {
    static int ilosc_aut=1000;
    static int ilosc_miejscpostojowych=5;
    static Postoj postoj;
    public Glowna(){
    }
    public static void main(String[] args) {
        postoj=new Postoj(ilosc_miejscpostojowych, ilosc_aut);
        for(int i=0;i<ilosc_aut;i++)
            new Auto(i,1000,postoj).start();
    }
}
