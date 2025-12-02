public class Turtletext {
    public static class turtle{
            public double x0,y0,a0;
            public turtle(double x0, double y0, double a0) {
                this.x0 = x0;
                this.y0 = y0;
                this.a0 = a0;
            }
            public void turnLeft(double delta){
                if(a0>=360){
                    a0 %= 360;
                }
                a0 += delta;
            }
            public void goForward(double step){
                double rad = Math.toRadians(this.a0);
                 double x1 =step * Math.cos(rad);
                 double y1 =step *  Math.sin(rad);
                 StdDraw.line(this.x0,this.y0,this.x0+x1,this.y0+y1);
                 this.x0 += x1 ;
                 this.y0 += y1;
            }
    }
    public static void main(String[] args){
            StdDraw.enableDoubleBuffering();
            StdDraw.setXscale(-2.0,2.0);
            StdDraw.setYscale(-2.0,2.0);
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(StdDraw.BLUE);
            double x0 = 0.5;
            double y0 = 0.0;
             double a0 = 60.0;
            double step = 1.0;
            turtle turtle1 = new turtle(x0, y0, a0);
            turtle1.goForward(step);
            turtle1.turnLeft(120.0);
            turtle1.goForward(step);
            turtle1.turnLeft(120.0);
            turtle1.goForward(step);
            turtle1.turnLeft(120.0);
            StdDraw.show();

    }
}
