package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVStream
{
    public ArrayList<String[]> records;
    public CSVStream(File file) throws FileNotFoundException
    {
        ArrayList<String[]> records = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext())
        {
            // Regex from https://github.com/lorenzofman/FinalProjectFDB/blob/master/DatabaseUtilsTools/Utils.cs
            records.add(scanner.nextLine().split(";(?=(?:[^\"]*\"[^\"]*\")*(?![^\"]*\"))"));
        }
    }
}
