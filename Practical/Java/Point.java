public class Point
{
    private double x,y;
    public Point(double x,double y)
    {
      this.x = x;
      this.y = y;
    }
    public void Translate(double x, double y)
    {
        this.x += x;
        this.y += y;
    }
    public double DistanceFrom(Point other)
    {
      double dx = this.x - other.x;
      double dy = this.y - other.y;
      return Math.sqrt(dx*dx + dy*dy);
    }
    public static double Distance(Point p1, Point p2)
    {
        return p1.DistanceFrom(p2);
    }
    public static void main(String[] args)
    {
        Point p = new Point(1.0,3.0);
        Point p1 = new Point(2.0,-1.0);
        
    }
}
