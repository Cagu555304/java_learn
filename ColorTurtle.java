import java.awt.*;

public  class ColorTurtle
{
    static  class  Colorturtle extends Turtletext.turtle
    {
        public Color color;

        public Colorturtle(double x0, double y0, double a0,Color color) {
            super(x0, y0, a0);
            this.color = color;
        }
        @Override
        public void goForward(double step) {
            StdDraw.setPenColor(color);
            double rad = Math.toRadians(this.a0);
            double x1 =step * Math.cos(rad);
            double y1 =step *  Math.sin(rad);
            StdDraw.line(this.x0,this.y0,this.x0+x1,this.y0+y1);
            this.x0 += x1 ;
            this.y0 += y1;
        }





    }
    public static void main(String[] args) {
        int n = 5;
        double angle = 360.0 / n;
        double step  = Math.sin(Math.toRadians(180.0/n));   // sin(pi/n)
        Color c = Color.RED;

        Colorturtle turtle = new Colorturtle(0.5, 0.0, 180.0/n,c); // 改写成ColorTurtle
        for (int i = 0; i < 10*n; i++) {
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }
    }
}
