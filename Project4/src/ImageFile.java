import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageFile extends CommonFile {
    private int imageHeight;
    private int imageWidth;
    private boolean isAnimated;

    public ImageFile(File image) throws IOException, InvalidImageFileException {
        super(true, false, "Preview");
        if (imageHeight <= 0 && imageWidth <= 0) {
            throw new InvalidImageFileException();
        }
        else if (super.getExtension().equals(".gif")) {
            isAnimated = true;
        }
        else {
            isAnimated = false;
            super.setFile(image);
            //TODO: set imageHeight and imageWidth
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
