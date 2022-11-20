import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class negatyw extends Thread {

    BufferedImage img;
    int w;
    int h;
    File input;
    String file;

    public negatyw(String file) {
        try {
            this.file = file;
            this.input = new File(file);
            img = ImageIO.read(input);
        } catch (Exception e) {
            System.out.println("NIE ZNALAZŁO DANEGO PLIKU W DANYM KATALOGU!!");
        }
    }

    public void run() {
        w = img.getWidth();
        h = img.getHeight();

        for(int i=1; i<h-1; i++) {
            for(int j=1; j<w-1; j++){

                Color c = new Color(img.getRGB(j, i));
                int red = (int)(c.getRed());
                int green = (int)(c.getGreen());
                int blue = (int)(c.getBlue());
                int final_red, final_green, final_blue;

                final_red = 255-red;
                final_green = 255-green;
                final_blue = 255-blue;
                Color newColor = new Color(final_red, final_green, final_blue);
                img.setRGB(j,i,newColor.getRGB());
            }
        }

        File ouptut = new File("negatyw" + file);

        try {
            ImageIO.write(img, "jpg", ouptut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
