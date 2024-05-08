package app;

import services.ImageService;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o caminho da imagem: ");
        String path = scan.nextLine();

        startProgram(scan, path);

        BufferedImage imagem =  ImageService.openImage(path);

        Ui.lineSeparator(); 

        ImageService.saveImage(imagem,"resources/copia.jpg");

        boolean loop = true;

        while (loop) {
            System.out.println("""

                Deseja rodar novamente?

                1 - Sim
                2 - Nao
                """);
            int op = scan.nextInt();

            if (op == 1){
                System.out.println("iniciou");
             startProgram(scan, path);
            }else {
                loop = false;
                System.exit(0);
            }
        }
       
      
    }

    public static void startProgram(Scanner scan,String path) throws IOException {
        Ui.lineSeparator();
        System.out.println("Escolha a opcão desejada:");
        Ui.menu();
        Ui.chooseAction(path,scan.nextInt(), scan);
        
    }
}
