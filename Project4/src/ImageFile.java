import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author alissahonigford arhonigford
 * @version 11/9/2019
 */
public class ImageFile extends CommonFile {
    private int imageHeight;
    private int imageWidth;
    private boolean isAnimated;

    public ImageFile(File image) throws IOException, InvalidImageFileException {
        super(true, false, "Preview");
        int height = ImageIO.read(image).getHeight();
        int width = ImageIO.read(image).getWidth();
        if (height <= 0 && width <= 0) {
            throw new InvalidImageFileException();
        } else {
            super.setFile(image);
            if (super.getExtension().equals(".gif"))
                isAnimated = true;
            else
                isAnimated = false;
            imageHeight = height;
            imageWidth = width;
            super.setFileSizeInBytes(image.length());
        }
    }

    @Override
    public String getFileType() {
        return "Image";
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public boolean animated() {
        return isAnimated;
    }

    @Override
    public String toString() {
        String s = "ImageFile[" + getFileType() + ", " + getFileSizeInBytes() + ", " + getFile().getName() + ", "
                + imageHeight + "x" + imageWidth + ", " + isAnimated + "]";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ImageFile) {
            if (super.equals(o)) {
                if (((ImageFile) o).animated() == isAnimated) {
                    if (((ImageFile) o).getImageHeight() == imageHeight) {
                        return (((ImageFile) o).getImageWidth() == imageWidth);
                    }
                }
            }
        }
        return false;
    }
}
