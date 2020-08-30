import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        String bookName;
        String query;
        Scanner s = new Scanner(System.in);
        System.out.println("What is the name of the book you would like to analyze?");
        bookName = s.nextLine();
        BookInformation bookInfo = new BookInformation(bookName);
        System.out.println("Enter the word or phrase you would like to search for.");
        query = s.nextLine();
        System.out.printf("%nThe phrase - %s - appears %d times in the file you requested, %s", query,
                bookInfo.instanceFinder(query), bookName);
        System.out.printf("%nThere are a total of %d " +
                "letters in the book.", bookInfo.charactersInBook());
        System.out.printf("%nThere are a total of %d digits in this book.",
                bookInfo.numbersInBook());
        System.out.printf("%nThank you for using the Book Analyzer!");
    }


}
