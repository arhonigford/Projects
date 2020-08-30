import java.io.*;
import java.util.Scanner;

public class FileDebug {

   public static void main(String [] args) throws Exception{
        Scanner s = new Scanner(System.in);
        System.out.println("What is the name of the file?");
        String file = s.nextLine();
        File f = new File(file);

        write(f);
        read(f);
    }

    public static void write(File f) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(f, true);
        PrintWriter pw = new PrintWriter(fos);

        pw.println("Here's the first Line!");
        pw.println("Here's the second Line!");
        pw.println("Here's the third Line!");

        pw.close();


    }

    public static void read(File f) throws IOException {
       FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        while(true){
            String line = bfr.readLine();
            if(line ==null)
                break;
            System.out.println(line);
        }




        bfr.close();
    }

}
