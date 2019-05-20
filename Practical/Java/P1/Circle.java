public class Circle {
   private double x;
   private double y;
   private double r;

   public Circle() {
      x = y = r = 0.0;
      System.out.println("NewCircle");
   }
   public Circle(double x, double y, double r)
   {
     this.x = x;
     this.y = y;
     this.r = r;
   }
   public double area() {
      return Math.PI * r * r;
   }
  
   public void setRadius(double radius){
      this.r = radius;
   }


}
