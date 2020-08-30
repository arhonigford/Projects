import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookInformation {
    private List<String> textInBook;

    public BookInformation(String filename) throws FileNotFoundException {
        File f = new File(filename);
        if(!f.exists()) {
            System.out.println("File Not Found");
            textInBook = readBook(filename);
        }
        else {
            textInBook = readBook(filename);



        }
    }

    private ArrayList<String> readBook(String filename) throws FileNotFoundException {
        File f = new File(filename);
        ArrayList<String> arr = new ArrayList<>();
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        while(true){
            String line = null;
            try {
                line = bfr.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(line == null)
                break;
            arr.add(line);
        }
        try {
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public int instanceFinder(String toFind){
        int count =0;
        for(String line : textInBook){
            for( String word : line.split(" ")) {
                if(word.contains(toFind))
                    count++;
            }
        }

        return count;
    }

    public int charactersInBook(){
        int count =0;
        for(String line : textInBook){
            for(int i =0; i<line.length(); i++){
                count++;
            }
        }
        return count;
    }
    public int numbersInBook() {
        int count = 0;
        for (String line : textInBook) {
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i)))
                    count++;
            }
        }
        return count;
    }
}
