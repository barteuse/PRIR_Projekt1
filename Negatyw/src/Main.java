public class Main {

    static public void main(String[] args) throws Exception {

        negatyw n1 = new negatyw("morant.jpeg");
        negatyw n2 = new negatyw("curry.jpg");
        
        n1.start();
        n2.start();

        try {
            n1.join();
            n2.join();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}