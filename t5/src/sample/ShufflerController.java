package sample;

import java.util.ArrayList;

public class ShufflerController<E>
{
    public ArrayList<E> Shuffle(ArrayList<E> sourceList) throws Exception
    {
        Shuffler<E> shuffler = new OnlineShuffler<>();
        ArrayList<E> shuffledList;
        try
        {
            shuffledList = shuffler.Shuffle(sourceList);
        }
        catch (Exception e)
        {
            // If fail drawback to offline shuffler
            shuffler = new OfflineShuffler<>();
            shuffledList = shuffler.Shuffle(sourceList);
        }
        return shuffledList;
    }
}
