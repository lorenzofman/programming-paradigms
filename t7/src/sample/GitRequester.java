package sample;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GitRequester implements Runnable {
    private String urlRequest;
    private RequestProcessable requestListener;
    public GitRequester(String url, RequestProcessable processable)
    {
        this.urlRequest = url;
        requestListener = processable;
    }
    @Override
    public void run() {
        try {
            URL url = new URL(urlRequest);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            JsonParser parser = new JsonParser();
            JsonArray results = parser.parse(in.readLine()).getAsJsonArray();
            System.out.println("Size: "+ results.size());
            for(JsonElement elem : results)
            {
                System.out.println(elem.getAsJsonObject().get("commit"));
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
