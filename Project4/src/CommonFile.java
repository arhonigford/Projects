import java.io.File;

public abstract class CommonFile {
    private boolean canOpen;
    private boolean canPlay;
    private File file;
    private long fileSizeInBytes;
    private String programToOpenIn;

    public CommonFile(){
        canOpen = false;
        canPlay = false;
        programToOpenIn = null;
    }

    public CommonFile(boolean canOpen, boolean canPlay, String programToOpenIn) {
        this.canOpen = canOpen;
        this.canPlay = canPlay;
        this.programToOpenIn = programToOpenIn;
    }

    public boolean getOpenable() {
        return canOpen;
    }

    public boolean getPlayable() {
        return canPlay;
    }

    public String getOpensWith() {
        return programToOpenIn;
    }

    public void setCanOpen(boolean open) {
        this.canOpen = open;
    }

    public void setCanPlay(boolean play) {
        this.canPlay = play;
    }

    public void setProgramToOpenIn(String program) {
        this.programToOpenIn = program;
    }

    public void setFileSizeInBytes(long fileSizeInBytes) {
        this.fileSizeInBytes = fileSizeInBytes;
    }

    public String getExtension () {
        if (file != null) {
            String extension = file.getName().substring(file.getName().indexOf('.'));
            return extension;
        }
        return null;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public long getFileSizeInBytes() {
        return fileSizeInBytes;
    }

    public abstract String getFileType();

    public String toString() {
        String s = "CommonFile[" + fileSizeInBytes + ", " + getExtension() + "]";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CommonFile) {
            if (((CommonFile) o).getOpenable() == canOpen) {
                if (((CommonFile) o).getPlayable() == canPlay) {
                    return (((CommonFile) o).getOpensWith().equals(programToOpenIn));
                }
            }
        }
        return false;
    }
}
