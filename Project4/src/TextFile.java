import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;

/**
 * @author alissahonigford arhonigford
 * @version 11/9/2019
 */
public class TextFile extends CommonFile {
    private long numberOfLines;

    public TextFile(File text) throws IOException, InvalidTextFileException {
        super(true, false, "TextEdit");
        if (text != null) {
            BufferedReader br = new BufferedReader(new FileReader(text));
            String line = br.readLine();
            if (line == null) {
                throw new InvalidTextFileException();
            } else {
                while (line != null) {
                    numberOfLines++;
                    line = br.readLine();
                }
                super.setFile(text);
                super.setFileSizeInBytes(text.length());
            }
        }
    }


    @Override
    public String getFileType() {
        return "Text";
    }

    public long getLines() {
        return numberOfLines;
    }

    public long getOccurrences(String charSequence) throws FileNotFoundException, IOException {
        long occurrences = 0;
        if (!getFile().exists()) {
            throw new FileNotFoundException();
        }
        else {
            BufferedReader bf = new BufferedReader(new FileReader(getFile()));
            String line = bf.readLine();
            while (line != null) {
                int count = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == charSequence.charAt(count))
                        count++;
                    else
                        count = 0;
                    if (count == charSequence.length() - 1)
                        occurrences = occurrences + 1;
                }
                line = bf.readLine();
            }
        }
        return occurrences;
    }

    @Override
    public String toString() {
        String s = "TextFile[" + getFileType() + ", " + getFileSizeInBytes() + ", " + getFile().getName() + ", "
                + numberOfLines + "]";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TextFile) {
            if (super.equals(o)) {
                if (((TextFile) o).getLines() == numberOfLines) {
                    return true;
                }
            }
        }
        return false;
    }

}
