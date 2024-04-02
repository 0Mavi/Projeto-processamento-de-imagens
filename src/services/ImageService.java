package services;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageService {

    public static BufferedImage openImage(String path) {

        File arquivo = new File(path);
        java.awt.image.BufferedImage imagem;
        try {
            imagem = ImageIO.read(arquivo);
        } catch (IOException e){
            System.out.println("Erro ao carregar a imagem");
            throw new RuntimeException(e);
        }
        return imagem;
    }

    public static void saveImage(BufferedImage imagem, String path) {

        File arquivo = new File(path);
        try {
            ImageIO.write(imagem,"jpg", arquivo);
        } catch (IOException e){
            System.out.println("Erro ao salvar a imagem");
            throw new RuntimeException(e);
        }
    }

    public static void displayImage(BufferedImage... imagens) {
        
        JFrame frame = new JFrame();
        frame.setTitle("Display");
        frame.getContentPane().setLayout(new FlowLayout());

        for (BufferedImage imagem: imagens){
            JLabel label = new JLabel(new ImageIcon(imagem));
            frame.getContentPane().add(label);
        }

        frame.pack();
        frame.setVisible(true);
    
    }

    public static void everyPixel (BufferedImage imagem){

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        for (int i = 0; i < largura; i++){
            for (int j = 0; j < altura; j++){
                Color corPixel = new Color(imagem.getRGB(i, j));
                System.out.println("Cor do pixel: " + corPixel);
            }
        }
    }

}
