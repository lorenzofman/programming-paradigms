package sample;

import java.util.List;

public class OfflineShuffler<E> extends Shuffler<E>
{
    @Override
    public void Shuffle(List<E> inputList)
    {
        int size = inputList.size();
        for(int i = 0; i < size; i++){
            int randomIdx = RandomRange(i,size);
            E randomElement = inputList.get(randomIdx);
            inputList.set(randomIdx, inputList.get(i));
            inputList.set(i, randomElement);
        }
    }
}
