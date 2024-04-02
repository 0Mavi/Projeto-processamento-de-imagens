package switches;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import app.App;
import filters.BrightnessFilter;

public class BrightnessSwitches {
    public static BufferedImage brightnessOption (String path, int value, Scanner scan ) throws IOException {

        switch (value) {
           case 1:
                System.out.println("Escolha o valor do brilho para ajustar a tonalidade (De 0 a 255): ");
                int bright = scan.nextInt();
               return BrightnessFilter.tintFilter(path,bright);

           case 2:
                System.out.println("Escolha o valor do brilho aditivo (De 0 a 255): ");
                bright = scan.nextInt();
               return BrightnessFilter.adaptiveBrightness(path,bright);

           case 3:
                System.out.println("Escolha o valor do brilho multiplicatico (De 0 a 255): ");
                float multiplyBright = scan.nextFloat();
               return BrightnessFilter.multiplicativeBrightness(path,multiplyBright);

           case 4:
                System.out.println("Escolha o valor para aumentar em YIQ (De 0 a 255): ");
                double brightY = scan.nextDouble();
               return BrightnessFilter.increaseY(path,brightY);

           case 5:
                System.out.println("Escolha o valor para multiplicar em YIQ (De 0 a 255): ");
                brightY = scan.nextDouble();
               return BrightnessFilter.multiplyY(path,brightY);
               
            case 6:
                App.startProgram(scan, path);

           default:
               break;
       }
       return null;
   }
}
