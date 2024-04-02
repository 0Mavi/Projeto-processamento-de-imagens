package filters;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import services.ImageService;
import services.YIQ;

public class BlackAndWhite {

     public static BufferedImage blackAndWhiteOnRedBase (String path) throws IOException {

        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                Color cor = new Color(imagem.getRGB(i,j));
                Color novaCor = new Color (cor.getRed(),cor.getRed(),cor.getRed());
                imagem.setRGB(i,j,novaCor.getRGB());
            }
        }

        return imagem;
    }

    public static BufferedImage blackAndWhiteOnGreenBase (String path) throws IOException {

        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                Color cor = new Color(imagem.getRGB(i,j));
                Color novaCor = new Color (cor.getGreen(),cor.getGreen(),cor.getGreen());
                imagem.setRGB(i,j,novaCor.getRGB());
            }
        }

        return imagem;
    }

    public static BufferedImage blackAndWhiteOnBlueBase (String path) throws IOException {

        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                Color cor = new Color(imagem.getRGB(i,j));
                Color novaCor = new Color (cor.getBlue(),cor.getBlue(),cor.getBlue());
                imagem.setRGB(i,j,novaCor.getRGB());
            }
        }

        return imagem;
    }

    public static BufferedImage blackAndWhiteFilter (String path) throws IOException {

        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                Color cor = new Color(imagem.getRGB(i,j));
                int media = (cor.getRed() + cor.getGreen() + cor.getBlue()) / 3;
                Color novaCor  = new Color(media,media,media);
                imagem.setRGB(i, j, novaCor.getRGB());
            }
        }

        return imagem;

    }

    public static BufferedImage binarizationFilter (String path) throws IOException {

        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                Color cor = new Color(imagem.getRGB(i,j));

                int media = (cor.getRed() + cor.getGreen() + cor.getBlue())/3;
                int brilho = brightness(media);

                Color novaCor = new Color(brilho,brilho,brilho);
                imagem.setRGB(i,j,novaCor.getRGB());
            }
        }

        return imagem;
    }

    public static int brightness (int valor){
        if (valor > 150){
            return 255;
        }
        return 0;
    }
    
}
