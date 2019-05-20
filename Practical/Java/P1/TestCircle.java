public class TestCircle
{
  public static void main(String[] args)
  {
      Circle[] circles = new Circle[10];
      for(int i = 0;i < circles.length; i++)
      {
        circles[i] = new Circle();
      }
      Point p = new Point(1.0,3.0);
      Point p1 = new Point(2.0,-1.0);
      System.out.println("DistanceBetweenPoints: " + Point.Distance(p,p1));
  }
}
