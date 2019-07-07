package sample;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Commit {
    private boolean fetching = false;
    public void startFetching()
    {
        fetching = true;
    }
    public boolean getFetching()
    {
        return fetching;
    }
    private SimpleStringProperty link;
    private SimpleFloatProperty avg;

    public float getAvg() {
        return avg.get();
    }

    public SimpleFloatProperty avgProperty() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg.set(avg);
    }

    public String getLink() {
        return link.get();
    }

    public SimpleStringProperty linkProperty() {
        return link;
    }

    public void setLink(String link) {
        this.link.set(link);
    }

    public int getCommitCount() {
        return commitCount.get();
    }

    public SimpleIntegerProperty commitCountProperty() {
        return commitCount;
    }

    public void setCommitCount(int commitCount) {
        this.commitCount.set(commitCount);
    }

    public int getTotalLength() {
        return totalLength.get();
    }

    public SimpleIntegerProperty totalLengthProperty() {
        return totalLength;
    }

    public void setTotalLength(int totalLength) {
        this.totalLength.set(totalLength);
        this.avg.set(this.totalLength.get()/this.commitCount.get());
    }

    private SimpleIntegerProperty commitCount;
    private SimpleIntegerProperty totalLength;

    public Commit(String link)
    {
        this.link =  new SimpleStringProperty(link);
        this.commitCount = new SimpleIntegerProperty(0);
        this.totalLength = new SimpleIntegerProperty(0);
        this.avg = new SimpleFloatProperty(0);
    }

}
