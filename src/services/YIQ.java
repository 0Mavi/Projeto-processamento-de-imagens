package services;

import java.awt.Color;

public class YIQ {

    private double y;
    private double i;
    private double q;


    public YIQ(int r, int g, int b) {
        this.y = 0.299 * r + 0.587 * g + 0.114 * b;
        this.i = 0.596 * r - 0.275 * g - 0.321 * b;
        this.q = 0.212 * r - 0.523 * g + 0.311 * b;
    }

    public YIQ() {

    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }

    public double getQ() {
        return q;
    }

    public void setQ(double q) {
        this.q = q;
    }



    public Color converterCor () {

        
        int r = (int) (this.y + 0.956 * this.i + 0.621 * this.q);
        int g = (int) (this.y - 0.272 * this.i - 0.647 * this.q);
        int b = (int) (this.y - 1.106 * this.i + 1.703 * this.q);

        r = Math.min(Math.max(r, 0), 255);
        g = Math.min(Math.max(g, 0), 255);
        b = Math.min(Math.max(b, 0), 255);

        Color novaCor = new Color(r,g,b);

        return novaCor;
    }





    


}
