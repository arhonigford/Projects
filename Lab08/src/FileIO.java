import java.io.*;

public class FileIO {
    public static void main(String[] args) throws Exception{
        File f = new File("output.txt");
        FileOutputStream fos = new FileOutputStream(f, true);
        PrintWriter pw = new PrintWriter(fos);

        pw.println("CS180 is isisisisis! is");
        pw.println("Lab 8 is a fun intro to File IO!");
        pw.close();

        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);

        while(true){
            String line = bfr.readLine();
            if(line == null)
                break;
            System.out.println(line);
        }

        bfr.close();
    }
}
