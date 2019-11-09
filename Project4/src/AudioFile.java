import java.io.File;

public class AudioFile extends CommonFile{
    private int songLength;

    public AudioFile(File audio, int songLengthInSeconds) throws InvalidAudioFileException {
            super(true, true, "iTunes");
            if (songLengthInSeconds <= 0 ) {
                throw new InvalidAudioFileException();
            }
            else {
                songLength = songLengthInSeconds;
                super.setFile(audio);
            }
    }

    @Override
    public String getFileType() {
        return "audio";
    }

    public String getSongLength() {
        int minutes = songLength/60;
        int seconds = songLength%60;
        String sLength = minutes + " minutes " + seconds + " seconds";
        return sLength;
    }

    public String toString() {
        String s = "AudioFile[" + getFileType() + ", " + getFileSizeInBytes() + ", " + getFile().getName() + ", "
                + getSongLength() + "]";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof AudioFile) {
            if (super.equals(o)) {
                if (((AudioFile) o).getSongLength().equals(getSongLength())) {
                    if (((AudioFile) o).getFile() == getFile()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
