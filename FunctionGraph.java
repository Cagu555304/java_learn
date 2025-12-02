public class FunctionGraph {
    public static void main(String[] args) {
        int N = 1000;
        double xMin = 0.0;
        double xMax = Math.PI;
        StdDraw.setXscale(xMin, xMax);
        StdDraw.setYscale(-2.2, 2.2);
        StdDraw.setPenRadius(0.03);
        StdDraw.setPenColor(StdDraw.BLUE);
        for (int i = 1; i < N; i++) {
            double x1 = xMin + i * (xMax - xMin) / N;
            double y1 = Math.sin(2*Math.PI*400*x1);
            StdAudio.play(y1);
        }
    }
}
