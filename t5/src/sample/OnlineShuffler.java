package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class OnlineShuffler<E> extends Shuffler<E>
{

    @Override
    protected ArrayList<E> Shuffle(ArrayList<E> list) throws Exception
    {
        ArrayList<E> newList = new ArrayList<>();
        //https://www.random.org/clients/http/
        BufferedReader reader = networkRandomIntegerList(list.size());
        ArrayList<Integer> convertedIntegers = convertBufferToListOfIntegers(reader);
        for(int i = 0; i < convertedIntegers.size(); i++)
        {
            newList.add(list.get(convertedIntegers.get(i)));
        }
        reader.close();
        return newList;
    }

    private ArrayList<Integer> convertBufferToListOfIntegers(BufferedReader reader) throws IOException
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String line;
        while ((line = reader.readLine()) != null)
        {
            list.add(Integer.parseInt(line));
        }
        return list;
    }

    private BufferedReader networkRandomIntegerList(int listSize) throws IOException, Exception
    {
        //https://www.random.org/clients/http/
        String urlString = String.format("https://www.random.org/sequences/?min=0&max=%d&col=1&format=plain&rnd=new",listSize - 1);
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        if(con.getResponseCode() != 200)
        {
            throw new Exception("Couldn't reach server");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        return in;
    }

}
