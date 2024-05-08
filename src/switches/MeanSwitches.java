package switches;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import app.App;
import services.MeanCalc;



public class MeanSwitches {
    public static BufferedImage meanOptions (String path, int value, Scanner scan ) throws IOException {

        switch (value) {
           case 1:
                System.out.println("Escolha o tamanho da media ");
                int tam = scan.nextInt();
                return MeanCalc.media(path,tam);

           case 2:
                System.out.println("Escolha o tamanho da media ");
                tam = scan.nextInt();
                return MeanCalc.mediana(path,tam);

            default:
                break;
       }
       return null;
    }
}   
