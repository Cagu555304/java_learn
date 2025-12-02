import java.awt.*;

public class VPercolation {
        public static boolean[][] random(int n, double p){
            boolean[][] isOpen = new boolean[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    isOpen[i][j]= StdRandom.bernoulli(p);
                }
            }
        return  isOpen;
        }
        public static void booleanprint(boolean[][] isOpen){
           int m = isOpen.length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(isOpen[i][j] ? 1 : 0);
                    System.out.print(' ');
                }
                System.out.println();
            }
        }
        public static boolean[][] Flow(boolean[][] isOpen){
            int m = isOpen.length;
            boolean[][] isFull = new boolean[m][m];
            for (int i = 0; i < m; i++){
                if (isOpen[0][i]==true){
                    isFull[0][i]=true;
                    int j = 1;
                    for (;j < m && isOpen[j][i]==true; j++){
                        isFull[j][i]=true;
                    }
                    for (;j<m;j++){
                        isFull[j][i]=false;
                    }
                }
                else {
                    for (int j = 0; j < m; j++){
                        isFull[j][i]=false;
                    }
                }
            }
            return isFull;
        }
        public static boolean percolates(boolean[][] isOpen){
            int m = isOpen.length;
            for (int i = 0; i < m; i++){
                if (isOpen[0][i]==true){
                    int j = 1;
                    for (;j < m && isOpen[j][i]==true; j++){

                    }
                    if (j == m){
                        return true;
                    }
                }
            }
        return  false;
        }
        public static void isopendraw(boolean[][] isOpen){
            int m = isOpen.length;
            StdDraw.setCanvasSize(m*200, m*200);
            StdDraw.setXscale(0, m*200);
            StdDraw.setYscale(m*200,0);
            StdDraw.setPenRadius(0.02*m);
            for (int i = 0; i < m; i++){
                for (int j = 0; j < m; j++){
                    if (isOpen[i][j]==false){
                        StdDraw.setPenColor(Color.black);
                        StdDraw.point((j*100)+50*m,(i*100)+50*m);

                    }
                    else{
                        StdDraw.setPenColor(Color.blue);
                        StdDraw.point((j*100)+50*m,(i*100)+50*m);

                    }
                }
            }
            StdDraw.show();
        }

        public static void main(String[] args) {
            int m = StdIn.readInt();
            int n = StdIn.readInt();
            boolean[][] isOpen = new boolean[m][m];
            boolean[][] isFull = new boolean[m][m];

            for (int i = 0; i < m; i++){
                for (int j = 0; j < m; j++){
                    isOpen[i][j] =  StdIn.readBoolean();
                }
            }
            isFull = Flow(isOpen);
            booleanprint(isFull);
            StdOut.println(percolates(isOpen));
            int number = StdRandom.uniformInt(10);
            double p = StdRandom.uniformDouble(0.01, 1.0);
            boolean[][] radisOpen = new boolean[number][number];
            radisOpen = random(number,p);
            booleanprint(radisOpen);
            boolean[][] radisFull = new boolean[number][number];
            radisFull = Flow(radisOpen);
            isopendraw(radisOpen);

        }
    }

