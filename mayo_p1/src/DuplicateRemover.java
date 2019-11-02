import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class DuplicateRemover {

    private HashSet<String> uniqueWords = new HashSet<String>();

    public void write(String outputFile) throws IOException {
        File outFile = new File(outputFile);
        FileOutputStream file = null;
        PrintWriter outFS = null;
        Iterator currentWord = null;

        if(outFile.exists()) {
            file = new FileOutputStream(outFile);
            outFS = new PrintWriter(file);
            currentWord = uniqueWords.iterator();
            System.out.println("Output file already exists...");
            System.out.println("Overwriting contents in output file...");
            while (currentWord.hasNext()) {
                outFS.println(currentWord.next());
                outFS.flush();
            }
            System.out.println("Closing output file...");
            file.close();
        }
        else{
            outFile.createNewFile();
            file = new FileOutputStream(outFile);
            outFS = new PrintWriter(file);
            currentWord = uniqueWords.iterator();
            System.out.println("Output file does not exist...");
            System.out.println("Creating new output file...");
            System.out.println("Writing contents in file...");
            while (currentWord.hasNext()) {
                outFS.println(currentWord.next());
                outFS.flush();
            }
            System.out.println("Closing output file...");
            file.close();
        }

    }

    public void remove(String dataFile) throws IOException{
        FileInputStream newFile = null;
        Scanner inFS = null;
        String fileWord;

        newFile = new FileInputStream(dataFile);
        inFS = new Scanner(newFile);

        System.out.println("Removing duplicate words in data file...");
        while(inFS.hasNext()){
            fileWord = inFS.next();
            uniqueWords.add(fileWord);
        }
        System.out.println("Closing data file...");
        newFile.close();

    }




}