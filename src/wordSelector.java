import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class wordSelector {

    List<String> dictionary = new ArrayList<String>();
    List<String> usedWords = new ArrayList<String>();

    public void createDictionary() throws IOException {
        // load data from file
        BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
        String line = reader.readLine();

        while (line != null) {
            dictionary.add(line);
            line = reader.readLine();
        }

        reader.close();
    }

    public String selectRandomWord(List dictionary){
        int randomValue = (int)(Math.random() * dictionary.size());
        String todaysWord = (String) dictionary.get(randomValue);
        for (int i = 0; i < usedWords.size(); i++){
            if (todaysWord.equals(usedWords.get(i))){
                System.out.print("Word has already been used this year");
                selectRandomWord(dictionary);
            }
        }
        usedWords.add(todaysWord);
        return todaysWord;
    }

    public static void main(String[] args) throws IOException {
        wordSelector ws = new wordSelector();
        ws.createDictionary();
        // Call below at the start of each day:
        System.out.println(ws.selectRandomWord(ws.dictionary));
    }
}
