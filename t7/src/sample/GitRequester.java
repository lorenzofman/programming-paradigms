package sample;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javafx.application.Platform;
import javafx.concurrent.Task;

import javax.naming.LimitExceededException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GitRequester extends Task {
    private Commit info;
    public GitRequester(Commit info)
    {
        this.info = info;
    }
    private String fetchCommits(String link) throws IOException, LimitExceededException {
        URL url = new URL(link);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        if(con.getResponseCode() == 403)
        {
            throw new LimitExceededException();
        }
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
    }
    public void run() {
        info.startFetching();
        String link = info.getLink();
        while(link != null)
        {
            try
            {
                link = fetchCommits(link);
            }
            catch (Exception e)
            {
                Platform.runLater(() ->  ExceptionHandler.displayException(e));
            }
            finally
            {
                break;
            }
        }
    }




    @Override
    protected Object call() {
        run();
        return null;
    }
}
