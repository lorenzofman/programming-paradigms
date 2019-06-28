package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CSVStream
{
    public ArrayList<String[]> records = new ArrayList<>();
    public CSVStream(File file) throws IOException
    {
        FileInputStream fis = new FileInputStream(file);
        //https://stackoverflow.com/questions/14169661/read-complete-file-without-using-loop-in-java/14169729
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        String str = new String(data, "UTF-8");
        // https://github.com/lorenzofman/FinalProjectFDB/blob/master/DatabaseUtilsTools/Utils.cs
        // https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
        String[] entries = str.split("\r\n(?=(?:[^\"]*\"[^\"]*\")*(?![^\"]*\"))");
        for(int i = 0; i < entries.length; i++)
        {
            records.add(entries[i].split(",(?=(?:[^\"]*\"[^\"]*\")*(?![^\"]*\"))"));
        }
    }
}
