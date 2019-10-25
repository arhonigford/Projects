import java.util.ArrayList;

public class WordSearcher {
    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        String wordLibrary = args[0];
        String puzzle = args[1];
        //String test ="TEST,SAMPLE,OUTPUT";
        //String puz = "XXTXXUXXPTXXUXXOXX";
        forward(wordLibrary,puzzle);
        backward(wordLibrary,puzzle);

        for(int i =0; i<ans.size();i++){
            System.out.println(ans.get(i));
        }

    }


    public static ArrayList<String> forward(String library, String puzzle){
        String [] words = library.split(",");

        for(int w =0;w<words.length;w++) {
            String word=words[w];
            String checkWord ="";
            int letterIndex=0;
            for (int i = 0; i < puzzle.length(); i++) {
                String letter = word.substring(letterIndex, letterIndex + 1);
                if (letter.equals(puzzle.substring(i,i+1))) {
                    checkWord = checkWord + letter;
                    letterIndex++;
                }
                if(checkWord.length()==word.length())
                    i=puzzle.length();
            }

            if(checkWord.equals(word)) {
                if(!ans.contains(word))
                    ans.add(word);
            }
        }
        return ans;

    }
    public static ArrayList<String> backward(String library, String puzzle){
        String [] words = library.split(",");
        for(int w =0;w<words.length;w++) {
            String word=words[w];
            String checkWord ="";
            int letterIndex=0;
            for (int i = puzzle.length()-1; i >=0; i--) {
                String letter = word.substring(letterIndex, letterIndex+1);
                if (letter.equals(puzzle.substring(i,i+1))) {
                    checkWord = checkWord+letter;
                    letterIndex++;
                }
                if(checkWord.equals(word)) {
                    i = -1;
                    if(!ans.contains(word))
                        ans.add(word);
                }

            }

        }
        return ans;
    }
}
