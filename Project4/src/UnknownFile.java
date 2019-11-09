import java.io.File;

public class UnknownFile extends CommonFile {

    public UnknownFile(File unknownFile) throws InvalidFileException{
        super(false, false, "Unknown Program");
        if(!unknownFile.getName().contains(".")) {
            throw new InvalidFileException();
        }
        else {
            super.setFile(unknownFile);

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
