import java.util.Random;

public class Transition {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        double a [][] = new double[n][n];
        double a1[] = new double [n];
        while (!StdIn.isEmpty()){
            int f    = StdIn.readInt();
            int nex  = StdIn.readInt();
            a1[f] ++;
            a[f][nex] ++;
        }
        for (int i = 0; i < n; i++){
            a1[i] = 0.9/a1[i];
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                a[i][j] = a[i][j] *a1[i]+0.02;
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(a[i][j] + " ");
            }
                StdOut.println("\n");
        }
       double[][] p = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                p[i][j] = a[i][j];
            }
        }
        for(int op = 0; op < 1000; op++){
            double[][] TEE = new double[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    double mum = 0;
                    for (int k = 0; k < n; k++){
                        mum += p[i][k] * a[k][j];
                    }
                    TEE[i][j] = mum;
                }
                System.arraycopy(TEE[i], 0, p[i], 0, n);
            }
        }


            for (int j = 0; j < n; j++){
                System.out.print(p[0][j] + " ");
        }
    };
}
