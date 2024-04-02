package switches;

import filters.PixelChange;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import app.App;

public class PixelSwitches {
    public static BufferedImage pixelOption (String path, int value, Scanner scan) throws IOException{
        
        switch (value) {
            case 1:

                return PixelChange.redPixel(path);

            case 2:

                return PixelChange.greenPixel(path);

            case 3:
                
                return PixelChange.bluePixel(path);
                
            case 4:
                App.startProgram(scan, path);

            default:
                break;
        }
        return null;

    }
}
