package ivan.samoylov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;

public class Main {


    public static void main(String[] args) throws Exception {
        final String FILE = "myfile.txt";
        BufferedReader reader = null;
        String line;
        int stringCounter = 0;
        int charCounter = 0;
        int wordCounter = 0;

        try{
              File file = new File(FILE);

              if(!file.exists()) {
                  file.createNewFile();
                }

               PrintWriter myWriter = new PrintWriter(file);
               myWriter.println("Suffering for a friend doubleth friendship.");
               myWriter.println("If you can't be good, be careful.");
               myWriter.println("Don't keep a dog and bark yourself");
               myWriter.close();

               reader = new BufferedReader(new FileReader(FILE));
               System.out.println("Text in file " + FILE + ":");

               while((line = reader.readLine()) != null){
                   stringCounter++;
                   charCounter += line.length();

                   if(line.length() != 0){
                       wordCounter++;
                       for (int i = 0; i < line.length(); i++) {
                           if (line.charAt(i) == ' '){
                               wordCounter++;
                           }
                       }
                   }
                   System.out.println(line);
               }
            }
        catch(Exception error){
            System.out.println(error.getMessage());
        }
        System.out.println();
        System.out.print("number of strings: " + stringCounter);
        System.out.print(", number of words: " + wordCounter);
        System.out.print(", number of chars: " + charCounter);
    }
}
