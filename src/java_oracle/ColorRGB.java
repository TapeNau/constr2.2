/**
 * ColorRGB
 * v. 1.0
 * Copyright (c) 4738551@stud.nau.edu.ua
 */
package java_oracle;

/**
 * Color-saving class
 *
 * @author Oleksandr Potapenko (4738551@stud.nau.edu.ua)
 * @version $Id$
 * @since 30.12.2020
 */
public class ColorRGB{

    // Values must be between 0 and 255.
    private int red;
    private int green;
    private int blue;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getRed(){
        return red;
    }

    public void setRed(int red){
        this.red = red;
    }

    public int getGreen(){
        return green;
    }

    public void setGreen(int green){
        this.green = green;
    }

    public int getBlue(){
        return blue;
    }

    public void setBlue(int blue){
        this.blue = blue;
    }

    public ColorRGB(int red,
                    int green,
                    int blue,
                    String name) {
        check(red, green, blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
    }

    private void check(int red,
                       int green,
                       int blue) {
        if (red < 0 || red > 255
                || green < 0 || green > 255
                || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    public ColorRGB invert() {
        return new ColorRGB(255 - red,
                255 - green,
                255 - blue,
                "Inverse of " + name);
    }

    public int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(final Object object) {
        return object instanceof ColorRGB
                && object.equals(this);
    }

    @Override
    protected ColorRGB clone() {
        ColorRGB clone = null;
        try {
            clone = (ColorRGB) super.clone();
        }catch(CloneNotSupportedException cns) {
            System.out.println("Error while cloning ImmutableRGB" + cns);
        }
        return clone;
    }
}
