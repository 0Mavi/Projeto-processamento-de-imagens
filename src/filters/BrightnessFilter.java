package filters;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import services.ImageService;
import services.YIQ;

public class BrightnessFilter {
    public static BufferedImage tintFilter(String path, int valor) throws IOException {

        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                Color cor = new Color(imagem.getRGB(i,j));
                Color novaCor = new Color(pickUpColor(cor.getRed(), valor), cor.getGreen(), cor.getBlue());
                imagem.setRGB(i, j,novaCor.getRGB());
            }
        }

        return imagem;
    }
    
    public static int pickUpColor (int cor, int valor) {
        if (cor + valor > 255){
            return 255;
        } else if (cor + valor < 100) {
            return 0;
        }

        return cor + valor;
    }

    public static BufferedImage adaptiveBrightness (String path, int valor) throws IOException {
        
        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){

                Color cor = new Color(imagem.getRGB(i,j));

                int r = Math.min(255, Math.max(0, cor.getRed() + valor));
                int g = Math.min(255, Math.max(0, cor.getGreen() + valor));
                int b = Math.min(255, Math.max(0, cor.getBlue() + valor));

                cor = new Color(r, g, b);
                imagem.setRGB(i, j, cor.getRGB());

            }
        } 

        return imagem;
    }

    public static BufferedImage multiplicativeBrightness (String path, float valor) throws IOException {
        
        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){

                Color cor = new Color(imagem.getRGB(i,j));

              
                int r = Math.min(255, (int)(cor.getRed() * valor));
                int g = Math.min(255, (int)(cor.getGreen() * valor));
                int b = Math.min(255, (int)(cor.getBlue() * valor));

                cor = new Color(r, g, b);
                imagem.setRGB(i, j, cor.getRGB());

            }
        } 

        return imagem;
    }

      public static BufferedImage increaseY (String path, double valor) throws IOException{
        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){

                Color cor = new Color(imagem.getRGB(i,j));

                YIQ yiq = new YIQ(cor.getRed(),cor.getGreen(),cor.getBlue());
                yiq.setY(Math.min(255, Math.max(0, yiq.getY() + valor)));
                Color novaCor = yiq.converterCor();
                imagem.setRGB(i,j, novaCor.getRGB());

            }
        }

        return imagem;
    }

    public static BufferedImage multiplyY (String path, double valor) throws IOException{
        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){

                Color cor = new Color(imagem.getRGB(i,j));

                YIQ yiq = new YIQ(cor.getRed(),cor.getGreen(),cor.getBlue());
                yiq.setY(Math.min(255, Math.max(0, yiq.getY() * valor)));
                Color novaCor = yiq.converterCor();
                imagem.setRGB(i,j, novaCor.getRGB());

            }
        }

        return imagem;
    }
}
