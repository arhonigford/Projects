import java.io.File;

/**
 * @author alissahonigford arhonigford
 * @version 11/9/2019
 */
public class UnknownFile extends CommonFile {

    public UnknownFile(File unknownFile) throws InvalidFileException {
        super(false, false, "Unknown Program");
        if (unknownFile.getName().indexOf('.') < 0 ||
                unknownFile.getName().indexOf('.') > unknownFile.getName().length()) {
            throw new InvalidFileException();
        } else {
            super.setFile(unknownFile);
            super.setFileSizeInBytes(unknownFile.length());
        }
    }


    @Override
    public String getFileType() {
        return "Unknown";
    }

    @Override
    public String toString() {
        String s = "UnknownFile[" + getFileType() + ", " + getFileSizeInBytes() + ", " + getFile().getName() + "]";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof UnknownFile) {
            if (super.equals(o)) {
                return true;
            }
        }
        return false;
    }

}
