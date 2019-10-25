import java.io.*;

/**
 * @author alissahonigford arhonigford
 * @version 10/23/2019
 */
public final class CafeUtilities extends Object {
    private CafeUtilities() {
    }

    public static void saveToFile(Cafe cafe, File file) throws NullPointerException, IOException {
        if (cafe == null || file == null) {
            throw new NullPointerException();
        } else {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cafe);
            oos.close();
            fos.close();
        }
    }

    public static Cafe readFromFile(File file) throws NullPointerException, IOException, ClassNotFoundException {
        if (file == null) {
            throw new NullPointerException();
        } else {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Cafe cafe = (Cafe) ois.readObject();
            ois.close();
            fis.close();
            return cafe;
        }
    }
}
