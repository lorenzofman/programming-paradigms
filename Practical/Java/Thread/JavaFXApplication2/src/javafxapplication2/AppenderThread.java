
import java.util.Random;

class AppenderThread extends Thread {
  
  protected AppendableText textArea;
  protected static final int SLEEP_MILLIS = 100;
  protected boolean random;
  protected Random randomGenerator;
  public AppenderThread(AppendableText textArea, boolean random) {
    this.textArea = textArea;
    this.random = random;
    if(random)
    {
        randomGenerator = new Random();
    }
  }
  public void run() 
  {
    int i = nextInt(-1);
    try {
      while (true) {
        final String str = "Counting: " + i + "\n";
        textArea.append(str);
        Thread.sleep(SLEEP_MILLIS);
        i = nextInt(i);
      }
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
  }
  
  private int nextInt(int current)
  {
      if(random)
          return randomGenerator.nextInt(100000);
      return current + 1;
  }
}
