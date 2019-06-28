package sample;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CSVFetcher
{
    private static final String fileName = "enade.csv";
    public static CSVReader FetchCSV(boolean forceServerRefresh) throws IOException
    {
        File file = new File(fileName);
        if(forceServerRefresh == false && file.exists())
        {
            return new CSVReader(file);
        }
        URL url = new URL(Main.defaultUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
        String str;
        while((str = in.readLine()) != null)
        {
            out.write(str);
            out.write("\r\n");
        }
        out.close();
        file = new File(fileName);
        return new CSVReader(file);
    }
}
