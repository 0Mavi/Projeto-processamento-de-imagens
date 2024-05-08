package app;

import java.io.IOException;
import java.util.Scanner;

import services.ImageService;
import switches.BWSwitches;
import switches.BrightnessSwitches;
import switches.MeanSwitches;
import switches.PixelSwitches;
import switches.RGBSwitches;


public class Ui {

    
    public static void menu(){

        System.out.println("""

                1 - Mudar cor do pixel
                2 - Filtros rgb
                3 - Preto e branco filtros
                4 - Brilho
                5 - Media e mediana
                6 - sair
                """);
    }

    public static void menuPixel(){
        Ui.lineSeparator();
        System.out.println("""
                Escolha uma opção:

                1 - Primeiro pixel vermelho
                2 - Pixel do meio Verde
                3 - Ultimo pixel Azul
                4 - Voltar
                """);
    };  

    public static void menuRgb(){
        Ui.lineSeparator();
        System.out.println("""
                Escolha uma opção:

                1 - Filtro vermelho
                2 - Filtro Verde
                3 - Filtro Azul
                4 - Inverter
                5 - Inverter em YIQ
                6 - Voltar
                """);
    };  

    public static void menuBW(){
        System.out.println("""
                Escolha uma opção:

                1 - Preto e Branco na base vermelha
                2 - Preto e Branco na base verde
                3 - Preto e Branco na base azul
                4 - Filtro preto e branco
                5 - Binarização
                6 - Voltar
                """);
    }; 

    public static void menuBrightness(){
        System.out.println("""
                Escolha uma opção:

                1 - Tonalidade 
                2 - Brilho aditivo 
                3 - Brilho multiplicatico 
                4 - Aumentar YIQ 
                5 - Multiplicar YIQ 
                6 - Voltar
                """);
    }; 

    public static void menuMean(){
        System.out.println("""
                Escolha uma opção:

                1 - Media
                2 - Mediana
                3 - Voltar
                """);
    }
    
    public static void chooseAction (String path, int value, Scanner scan) throws IOException{
      

        switch (value) {
            case 1:
                menuPixel();
                int op = scan.nextInt();
                ImageService.displayImage(PixelSwitches.pixelOption(path, op,scan));
                break;

            case 2:
                menuRgb();
                op = scan.nextInt();
                ImageService.displayImage(RGBSwitches.rgbOption(path, op,scan));
                break;

            case 3:
                menuBW();
                op = scan.nextInt();
                ImageService.displayImage(BWSwitches.bwOption(path, op,scan));
                break;

            case 4:
                menuBrightness();
                op = scan.nextInt();
                ImageService.displayImage(BrightnessSwitches.brightnessOption(path, op, scan));
                break;

            case 5: 
                menuMean();
                op = scan.nextInt();
                ImageService.displayImage(MeanSwitches.meanOptions(path, value, scan));


            case 6:
                System.exit(0);
                break;
        
            default:
                break;
        }

        
    }

    public static void lineSeparator (){
        System.out.println(" ");
        System.out.println("--------------------------------------------");
    }
}
