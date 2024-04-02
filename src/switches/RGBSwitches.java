package switches;

import filters.RGBFilters;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import app.App;

public class RGBSwitches {

    public static BufferedImage rgbOption (String path, int value, Scanner scan) throws IOException {

         switch (value) {
            case 1:

                return RGBFilters.redFilter(path);

            case 2:

                return RGBFilters.greenFilter(path);

            case 3:
                
                return RGBFilters.blueFilter(path);

            case 4:
                
                return RGBFilters.invertFilter(path);

            case 5:
                
                return RGBFilters.invertY(path);

            case 6:
                App.startProgram(scan, path);
                return null;


            default:
                break;
        }
        return null;
    }
}   
