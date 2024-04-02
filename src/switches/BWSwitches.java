package switches;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import app.App;
import filters.BlackAndWhite;

public class BWSwitches {

     public static BufferedImage bwOption (String path, int value, Scanner scan) throws IOException {

         switch (value) {
            case 1:

                return BlackAndWhite.blackAndWhiteOnRedBase(path);

            case 2:

                return BlackAndWhite.blackAndWhiteOnGreenBase(path);

            case 3:
                
                return BlackAndWhite.blackAndWhiteOnBlueBase(path);

            case 4:
                
                return BlackAndWhite.blackAndWhiteFilter(path);

            case 5:
                
                return BlackAndWhite.binarizationFilter(path);
                
            case 6:
                App.startProgram(scan, path);

            default:
                break;
        }
        return null;
    }
}
