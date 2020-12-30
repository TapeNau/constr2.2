package java_oracle_DTO;

import java_oracle.ColorRGB;

public class ColorDTO {
    private int red;
    private int green;
    private int blue;
    private String name;

    public int getRed() {
        return red;
    }

    public void setRed (int red){
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen (int green){
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue (int blue){
        this.blue = blue;
    }

    public String getName() {
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setAll(ColorRGB rgb){
        this.name = rgb.getName();
        this.red = rgb.getRed();
        this.green = rgb.getGreen();
        this.blue = rgb.getBlue();
    }
}
