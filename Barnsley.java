public class Barnsley {
    public static void main(String[] args) {
        int n = 50000;
        StdDraw.setScale(-0.1, 1.1);
        StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.setPenColor(0, 114, 0);
        double x = 0.5;
        double y = 0.0;

        for (int i = 0; i < n; i++) {
            double p = StdRandom.uniformDouble(0.0, 1.0);
            if(p <= 0.01){
                x=0.5;
                y *=0.16;
            }
            else if (p>0.01 && p<=0.06){
                x=0.20 * x - 0.26 * y + 0.400;
                y = 0.23 * x + 0.22 * y - 0.045;
            }
            else if (p>0.06 && p<=0.12){
                x=-0.15 * x + 0.28 * y + 0.575;
                y=0.26 * x + 0.24 * y - 0.086;
            }
            else {
                x=0.85 * x + 0.04 * y + 0.075;
                y=-0.04 * x + 0.85 * y + 0.180;
            }
            StdDraw.point(x, y);
        }
    }
}





