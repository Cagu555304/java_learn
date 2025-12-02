public class PlayA {
    public static void main(String[] args) {
        double t = 10.0;          // 10 秒
        int    b = 44100;       // CD 音质
        int    n = (int)(t * b);
        double[] a = new double[n];

        double freq = 440.0;             // A4 音高
        for (int i = 0; i < n; i++) {
            a[i] = Math.sin(2 * Math.PI * freq * i / b);
        }

        StdAudio.play(a);

    }
}