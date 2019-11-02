import java.io.*;
import java.util.*;

public class DuplicateCounter {

    private HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void count(String dataFile) throws IOException{
        FileInputStream newFile = null;
        Scanner inFS = null;
        newFile = new FileInputStream(dataFile);
        inFS = new Scanner(newFile);
        String fileWord;

        //putting words from file into an arraylist
        ArrayList<String> wordsFromFile = new ArrayList<String>();
        while(inFS.hasNext()) {
            fileWord = inFS.next();
            wordsFromFile.add(fileWord);
        }

        System.out.println("Counting duplicate words in data file...");
        for(String i : wordsFromFile){
            Integer j = wordCounter.get(i);
            wordCounter.put(i, (j == null) ? 1 : j + 1); //adding strings and count values to HashMap
        }
        System.out.println("Closing data file...");
        newFile.close();
    }

    public void write(String outputFile) throws IOException {
        File outFile = new File(outputFile);
        FileOutputStream file = null;
        PrintWriter outFS = null;
        Iterator wordCounterIterator = wordCounter.entrySet().iterator();

        if(outFile.exists()) {
            file = new FileOutputStream(outFile);
            outFS = new PrintWriter(file);
            System.out.println("Output file already exists...");
            System.out.println("Overwriting contents in output file...");
            while (wordCounterIterator.hasNext()) {
                Map.Entry mapElem = (Map.Entry)wordCounterIterator.next();
                int count = ((int)mapElem.getValue());
                outFS.println(mapElem.getKey() + " : " + count);
                outFS.flush();
            }
            System.out.println("Closing output file...");
            file.close();
        }

        else{
            outFile.createNewFile();
            file = new FileOutputStream(outFile);
            outFS = new PrintWriter(file);
            System.out.println("Output file does not exist...");
            System.out.println("Creating new output file...");
            System.out.println("Writing contents in file...");
            while (wordCounterIterator.hasNext()) {
                Map.Entry mapElem = (Map.Entry)wordCounterIterator.next();
                int count = ((int)mapElem.getValue());
                outFS.println(mapElem.getKey() + ", " + count);
                outFS.flush();
            }
            System.out.println("Closing output file...");
            file.close();
        }

    }



}
