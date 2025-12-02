public class AverageFile {
        public static void main(String[] args){
            double a =0;
            int number = 0;
            while(!StdIn.isEmpty()){
                a += StdIn.readDouble();
                number++;
                double b = a/number;
                StdOut.print("\n");
                StdOut.print(b);
            }
        }
    }
