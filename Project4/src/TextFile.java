import java.io.*;

public class TextFile extends CommonFile {
    private long numberOfLines;

    public TextFile(File text) throws IOException, InvalidTextFileException {
        super(true, false, "TextEdit");
        if (text.length() <= 0) {
            throw new InvalidTextFileException();
        }
        else {
            numberOfLines = text.length();
            super.setFile(text);
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
        BufferedReader bf = new BufferedReader(new FileReader(getFile()));
        String line = bf.readLine();
        long occurrences = 0;
        if (!getFile().exists())
            throw new FileNotFoundException();
        while (line != null) {
            int count = 0;
            for (int i = 0; i < line.length(); i++) {
               if (line.charAt(i) ==  charSequence.charAt(count))
                   count++;
               else
                   count = 0;
               if (count == charSequence.length()-1)
                   occurrences = occurrences + 1;
            }
            line = bf.readLine();
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
