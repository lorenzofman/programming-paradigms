package sample;// https://softwareengineering.stackexchange.com/questions/2715/should-curly-braces-appear-on-their-own-line
// I will be consistent
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomPickerCmd {

    public static void main(String[] args) throws Exception
    {
        String path = args[0];
        ArrayList<String> listOfNames = readListFromFile(path);
        Shuffler<String> shuffler = new OnlineShuffler<>();
        listOfNames = shuffler.Shuffle(listOfNames);
        displayOneByOne(listOfNames);
    }

    private static ArrayList<String> readListFromFile(String path) throws FileNotFoundException
    {
        String workingDirectory = System.getProperty("user.dir") + "\\";
        File file = new File(workingDirectory + path);
        ArrayList<String> listOfNames = new ArrayList<>();
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
        {
            listOfNames.add(sc.nextLine());
        }
        return listOfNames;
    }

    private static void displayOneByOne(ArrayList<String> list) throws IOException
    {
        int size = list.size();
        for(int i = 0; i < size; i++)
        {
            System.out.print(list.get(i));
            System.in.read();
        }
    }
}
