import java.io.File;

/**
 * @author alissahonigford arhonigford
 * @version 11/9/2019
 */
public class VideoFile extends CommonFile {
    private long videoLengthInSeconds;

    public VideoFile(File video, long videoLength) throws InvalidVideoFileException {
        super(true, true, "Quicktime Player");
        if (videoLength <= 0) {
            throw new InvalidVideoFileException();
        } else {
            videoLengthInSeconds = videoLength;
            super.setFile(video);
            super.setFileSizeInBytes(video.length());
        }
    }


    @Override
    public String getFileType() {
        return "Video";
    }

    public String getVideoLength() {
        long minutes = videoLengthInSeconds / 60;
        long seconds = videoLengthInSeconds % 60;
        String sLength = minutes + " minutes and " + seconds + " seconds";
        return sLength;
    }

    @Override
    public String toString() {
        String s = "VideoFile[" + getFileType() + ", " + getFileSizeInBytes() + ", " + getFile().getName() + ", "
                + getVideoLength() + "]";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof VideoFile) {
            if (super.equals(o)) {
                if (((VideoFile) o).getVideoLength().equals(getVideoLength())) {
                    return true;
                }
            }
        }
        return false;
    }
}
