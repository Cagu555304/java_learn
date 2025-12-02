import java.awt.Color;
public class Grayscale {
    public static void main(String[] args){
        Picture picture = new Picture("image-1.png");
        int width = picture.width();
        int height = picture.height();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = picture.get(x, y);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int gray = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
                Color grayColor = new Color(gray, gray, gray);
                picture.set(x, y, grayColor);
            }
        }
        picture.show();
    }
}
