public class topwatch {
    public  static class Stopwatch {
        public long StateTime() {
            long _T = System.currentTimeMillis();
            return  _T;
        }

        public long NewTime() {
            long _N = System.currentTimeMillis();
            return _N;
        }
        public long elapsedTime(long _T) {
            return (System.currentTimeMillis() - _T) ;
        }
        public long reset() {
            long _T = System.currentTimeMillis();
            return _T;
        }

    }



    public static void main(String[] args) {
       Stopwatch twatch1 = new Stopwatch();
        long T = twatch1.StateTime();
        double sum1 = 0.0;
        for (int i = 1; i <= 1000000000; i++) {
            sum1 += Math.sqrt(i);
        }
        long TAll = twatch1.elapsedTime(T);
        StdOut.println(TAll);
        StdOut.println("dsfadf");
    }
}
