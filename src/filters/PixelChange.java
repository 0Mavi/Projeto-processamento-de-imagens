package filters;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import services.ImageService;

public class PixelChange {

    public static BufferedImage bluePixel (String path ) throws IOException {

        BufferedImage imagem = ImageService.openImage(path);

        Color novaCor = new Color(0, 0, 255);
        imagem.setRGB(0, 0, novaCor.getRGB());

        return imagem;
        
    }

    public static BufferedImage greenPixel (String path ) throws IOException{

        BufferedImage imagem = ImageService.openImage(path);

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        Color novaCor = new Color(0,255,0);

        imagem.setRGB((largura/2), (altura/2), novaCor.getRGB());

        return imagem;
        
    }

    public static BufferedImage redPixel (String path) throws IOException {

        BufferedImage imagem = ImageService.openImage(path);

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        Color novaCor = new Color(255, 0, 0);
        imagem.setRGB(largura - 1, altura - 1, novaCor.getRGB());

        return imagem;
        
    }


}
