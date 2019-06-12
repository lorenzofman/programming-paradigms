package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public abstract class Shuffler<E>
{
    protected abstract ArrayList<E> Shuffle(ArrayList<E> list) throws Exception;
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
