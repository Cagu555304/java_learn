public class BirthdayParadox {
    public static int p(){
        int[] birthday = new int[365];
        int people = 0;
        int n = 0;
        while (true) {
            int day = StdRandom.uniformInt(365);
            if (birthday[day] == 1) {
                return people + 1;
            }
            birthday[day] = 1;
            people++;
        }
    }

    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);
        long total = 0;
        for (int t = 0; t < trials; t++) {
            total += p();
        }
        double avg = (double) total / trials;
        StdOut.printf("%.5f%n", avg);
    }
}
