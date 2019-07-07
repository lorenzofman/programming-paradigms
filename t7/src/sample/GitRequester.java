package sample;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitRequester extends Task {
    private Commit info;
    public GitRequester(Commit info)
    {
        this.info = info;
    }
    public void run() {
        try {
            info.startFetching();
            URL url = new URL(info.getLink());
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

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    


    @Override
    protected Object call() {
        run();
        return null;
    }
}
