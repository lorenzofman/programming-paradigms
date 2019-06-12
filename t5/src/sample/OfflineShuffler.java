package sample;

import java.util.ArrayList;

public class OfflineShuffler<E> extends Shuffler<E>
{
    @Override
    public ArrayList<E> Shuffle(ArrayList<E> inputList)
    {
        ArrayList<E> newList = new ArrayList<>();
        for(int i = 0; i < inputList.size(); i++)
        {
            newList.add(inputList.get(RandomRange(i, inputList.size())));
        }
        return newList;
    }
}
