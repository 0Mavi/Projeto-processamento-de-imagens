package filters;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import services.ImageService;
import services.YIQ;

public class RGBFilters {
    public static BufferedImage redFilter (String path) throws IOException {

        BufferedImage imagem = ImageService.openImage(path);


        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                Color cor = new Color(imagem.getRGB(i,j));
                Color novaCor = new Color(cor.getRed(),0,0);
                imagem.setRGB(i,j,novaCor.getRGB());
            }
        }

        return imagem;
        
    }

    public static BufferedImage greenFilter (String path) throws IOException {

        BufferedImage imagem = ImageService.openImage(path);


        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                Color cor = new Color(imagem.getRGB(i,j));
                Color novaCor = new Color(0,cor.getGreen(),0);
                imagem.setRGB(i,j,novaCor.getRGB());
            }
        }

        return imagem;
        
    }

    public static BufferedImage blueFilter (String path) throws IOException {

        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                Color cor = new Color(imagem.getRGB(i,j));
                Color novaCor = new Color(0,0,cor.getBlue());
                imagem.setRGB(i,j,novaCor.getRGB());
            }
        }

        return imagem;
        
    }

    public static BufferedImage invertFilter (String path) throws IOException {
        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){
                Color cor = new Color(imagem.getRGB(i,j));
                Color novaCor = new Color(255 - cor.getRed(), 255 - cor.getGreen(), 255 - cor.getBlue());
                imagem.setRGB(i, j, novaCor.getRGB());
            }
        }

        return imagem;

    }

    public static BufferedImage invertY (String path) throws IOException{
        BufferedImage imagem = ImageService.openImage(path);

        for(int i = 0; i < imagem.getWidth();i++){
            for(int j = 0;j < imagem.getHeight(); j++){

                Color cor = new Color(imagem.getRGB(i,j));

                YIQ yiq = new YIQ(cor.getRed(),cor.getGreen(),cor.getBlue());
                yiq.setY(255 - yiq.getY());
                Color novaCor = yiq.converterCor();
                imagem.setRGB(i, j,novaCor.getRGB());
            }
        }
        
        return imagem;
    
    }
}
