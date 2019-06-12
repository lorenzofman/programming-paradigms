package sample;

import java.util.List;
import java.util.Random;

public abstract class Shuffler<E>
{
    protected abstract void Shuffle(List<E> list);
    private static Random randomGenerator;
    protected int RandomRange(int min, int max)
    {
        return randomGenerator.nextInt(max-min) + min;
    }

    public Shuffler()
    {
        randomGenerator = new Random();
    }
}
