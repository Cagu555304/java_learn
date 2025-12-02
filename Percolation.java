import java.awt.*;

public class Percolation {
    public static boolean[][] judge=new boolean[20][20];
    public static void clearjudge(){
        for(int i = 0; i < judge.length; i++){
            for(int j = 0; j < judge.length; j++){
                judge[i][j] = false;
            }
        }
    };

    public static boolean[][] random(int n, double p){
        boolean[][] isOpen = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                isOpen[i][j]= StdRandom.bernoulli(p);
            }
        }
        return  isOpen;
    }
    public static void flow(boolean[][] isOpen, int i, int j) {
        int m = isOpen.length-1;
        int typei=-1;
        int typej=-1;
        if(i==0){typei=0;}
        if(j==0){typej=0;}
        if (i>0 && i<m){typei=1;}
        if (j>0 && j<m){typej=1;}
        if(i==m){typei=2;}
        if(j==m){typej=2;}
        if (i==0){
            if (isOpen[i][j] == false){
                return;
            }
        }
        switch (typei){
            case 0:
            if (isOpen[i + 1][j] == true && judge[i + 1][j] == false) {
                judge[i + 1][j] = true;
                flow(isOpen, i + 1, j);
            }
            break;
            case 1:
                if(isOpen[i - 1][j] == true && judge[i - 1][j] == false) {
                    judge[i - 1][j] = true;
                    flow(isOpen, i - 1, j);
                }
                if (isOpen[i + 1][j] == true && judge[i + 1][j] == false) {
                    judge[i + 1][j] = true;
                    flow(isOpen, i + 1, j);
                }
                break;
            case 2: if(isOpen[i - 1][j] == true && judge[i - 1][j] == false) {
                judge[i - 1][j] = true;
                flow(isOpen, i - 1, j);
            }
            break;
            default:
                break;
        }
        switch (typej){
            case 0:if (isOpen[i][j + 1] == true && judge[i][j + 1] == false) {
                judge[i][j + 1] = true;
                flow(isOpen, i, j + 1);
            }
            break;
            case 1:if (isOpen[i][j + 1] == true && judge[i][j + 1] == false) {
                judge[i][j + 1] = true;
                flow(isOpen, i, j + 1);
                }
                if (isOpen[i][j - 1] == true && judge[i][j - 1] == false) {
                    judge[i][j - 1] = true;
                    flow(isOpen, i, j - 1);
                }
                break;
            case 2:if (isOpen[i][j - 1] == true && judge[i][j - 1] == false) {
                judge[i][j - 1] = true;
                flow(isOpen, i, j - 1);
            }
            break;
            default:break;
        }
    }
    public static void booleanprint(boolean[][] isOpen){
        int m = isOpen.length;
        StdOut.println("\n");
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
        clearjudge();
        boolean[][] isFull = new boolean[m][m];
        for(int i = 0; i < m; i++){
            flow(isOpen,0,i);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                isFull[i][j] = judge[i][j];
            }
        }
        return isFull;
    }
    public static boolean percolates(boolean[][] isOpen){
        int m = isOpen.length;
        clearjudge();
        boolean[][] isFull = new boolean[m][m];
        for(int i = 0; i < m; i++){
            flow(isOpen,0,i);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                isFull[i][j] = judge[i][j];
            }
        }
        for (int i=0; i < m; i++){
            if(isFull[m-1][i]==true){
                return true;
            }
        }
        return false;
    }
    public static void  visualize(boolean[][] isOpen){
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
    public static double[] sort(double[] a){
        int n = a.length;
        for (int i = 1; i < n; i++) {
            double key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return a;
    }
    public static void  evaluate(int testtime){
        double[] x1 = new double[testtime];
        double[] y1 = new double[testtime];
        for(int i = 0; i < testtime; i++){
            int number = StdRandom.uniformInt(5, 11);
            double totel = 0;
            double p = StdRandom.uniformDouble(0, 1.0);
            for (int j = 0; j < 20; j++) {
                boolean[][] radisOpen = new boolean[number][number];
                radisOpen = random(number,p);
                if(percolates(radisOpen) == true){
                    totel++;
                };
            }
            totel = totel/20;
            x1[i] = p*1500+100;
            y1[i] = totel*800+100;
        }
        x1 = sort(x1);
        y1 = sort(y1);
        for (int i = 0; i < testtime-1; i++){
            StdDraw.line(x1[i],y1[i],x1[i+1],y1[i+1]);
        }
        StdDraw.show();
    }

    public static void main(String[] args) {
        int testtime = StdIn.readInt();
        StdDraw.setPenColor(Color.black);
        StdDraw.setPenRadius(0.02);
        StdDraw.setCanvasSize(1700,1000); //1500 800
        StdDraw.setXscale(0, 1700);
        StdDraw.setYscale(0, 1000);
        StdDraw.line(100,100,1600,100);//1600-100
        StdDraw.line(100,100,100,900); //900-100
        for (int i = 0; i <= 10; i++) {
            String s   = String.format("%.1f", i / 10.0);
            StdDraw.text( (i/10.0)*1500+100, 50, s);
        }
        StdDraw.text(50,900 ,"1");
        evaluate(testtime);
    }
}