package sample;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitRequester extends Task {
    private Commit info;
    public GitRequester(Commit info)
    {
        this.info = info;
    }
    private String fetchCommits(String link)
    {
        try{
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            JsonParser parser = new JsonParser();
            JsonArray results = parser.parse(in.readLine()).getAsJsonArray();
            for(JsonElement elem : results)
            {
                info.setCommitCount(info.getCommitCount() + 1);
                String message = elem.getAsJsonObject().get("commit").getAsJsonObject().get("message").getAsString();
                info.setTotalLength(info.getTotalLength() + message.length());
            }
            String str = con.getHeaderFields().get("Link").get(0);
            String next = str.split(";")[0];
            next = next.replace("<","");
            next = next.replace(">","");
            return next;

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void run() {
        info.startFetching();
        String link = info.getLink();
        while(link != null)
        {
            link = fetchCommits(link);
        }
    }




    @Override
    protected Object call() {
        run();
        return null;
    }
}
