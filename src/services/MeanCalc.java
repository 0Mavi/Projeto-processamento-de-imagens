package services;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class MeanCalc {

    
    public static BufferedImage media(String path, int tam ) throws IOException{
        BufferedImage imagem = ImageService.openImage(path);

       
        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                if (eBorda(imagem, j, i, tam)){
                    continue;
                }
                int avg = pegarAvg(imagem,j,i,tam);
                imagem.setRGB(i, j, new Color(avg,avg,avg).getRGB());
            }
        }
        
       return imagem;

    }

    public static BufferedImage mediana(String path, int tam ) throws IOException{
        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                if (eBorda(imagem, j, i, tam)){
                    continue;
                }
                int mediana = pegarMediana(imagem, i, j, tam);
                imagem.setRGB(i, j, new Color(mediana,mediana,mediana).getRGB());
            }
        }

        return imagem;

    }

    private static int pegarAvg(BufferedImage imagem, int i, int j, int tam) {
        int[] red = arrayVermelho(imagem, i, j, tam);
        return (Arrays.stream(red).sum() / (tam * tam));
    }

    private static int pegarMediana(BufferedImage imagem, int i, int j, int size){
        int[] red = arrayVermelho(imagem, i, j, size);
        Arrays.sort(red);
        return red[red.length / 2];
    }

    private static int[] arrayVermelho(BufferedImage imagem, int i, int j, int size) {
        int[] red = new int[size * size];
        int count = 0;
        for(int k = - pegarLimite(size); k <= pegarLimite(size); k++){
            for(int l = -pegarLimite(size); l <= pegarLimite(size); l++){
                Color color = new Color(imagem.getRGB(i + k, j + l));
                red[count] = color.getRed();
                count++;
            }
        }
        return red;
    }

    private static boolean eBorda (BufferedImage imagem, int j, int i, int tam){
      
        return j < tam / 2
                || i < tam / 2
                || i >= imagem.getWidth() - tam / 2
                || j >= imagem.getHeight() - tam / 2;
    }

    private static int pegarLimite (int tam){
        return Math.floorDiv(tam, 2);
    }

}
