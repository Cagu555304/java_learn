public class AddInts {
    public static void main(String[] args){
        int a = StdIn.readInt();
        StdOut.print(a);
        System.out.println("round");
        int b = 0;
        for(int i =0; i<a;i++){
            b += StdIn.readInt();
        }
        StdOut.print(b);
    }
}
