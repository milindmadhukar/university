// Create a Class called file Handling and Perform the following operations 
//
// 1.Read the data from the File 
//
// 2.Write the same data to the another File 
//
// 3.Count the number of words in the file 
//
// 4. Display the Unique words in the file 

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

class FileHandling {

  public void createSampleFile() throws IOException {
    FileWriter fw = new FileWriter("file.txt");
    fw.write("This is a test file to perform IO operations\nThis is a line\nAnother one");
    fw.close();
  }

  public String readData() throws IOException {
    FileReader fr = new FileReader("file.txt");
    int i;
    String data = "";

    while ((i = fr.read()) != -1) {
      data += (char) i;
    }

    fr.close();

    return data;
  }

  public void writeData() throws IOException {
    FileReader fr = new FileReader("file.txt");
    FileWriter fw = new FileWriter("file2.txt");
    
    int i;
    while ((i = fr.read()) != -1) {
      fw.write((char) i);
    }

    fr.close();
    fw.close();
  }

  public int countWords() throws IOException {
    FileReader fr = new FileReader("file.txt");
    Scanner sc = new Scanner(fr);
    int count = 0;
    while (sc.hasNext()) {
      sc.next();
      count++;
    }
    sc.close();
    fr.close();

    return count;
  }

  public void displayUniqueWords() throws IOException {
    FileReader fr = new FileReader("file.txt");
    Scanner sc = new Scanner(fr);
    String[] words = new String[countWords()];
    int i = 0;
    while (sc.hasNext()) {
      words[i] = sc.next();
      i++;
    }
    sc.close();

    for (int j = 0; j < words.length; j++) {
      for (int k = j + 1; k < words.length; k++) {
        if (words[j].equals(words[k])) {
          words[k] = "";
        }
      }
    }

    for (int j = 0; j < words.length; j++) {
      if (words[j] != "") {
        System.out.println(words[j]);
      }
    }
  }
}

public class Excercise61 {
  public static void main(String[] args) {
    FileHandling fh = new FileHandling();
    try {
      fh.createSampleFile();
      System.out.println(fh.readData());

      fh.writeData();

      System.out.println(fh.countWords());

      fh.displayUniqueWords();

    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
