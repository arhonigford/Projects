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
}
