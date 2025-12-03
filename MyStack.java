public class MyStack {

    public static class mystack{
        public int n;
        public Node first = null;
        public class    Node {
            public String  data;
            public Node  next;
            public Node prev;
        }
        public boolean isEmpty(){
            return n==0;
        }
        public void push(String data){
            Node newNode = new Node();
            newNode.prev=first;
            newNode.data=data;
            newNode.next=null;
            first = newNode;
            n++;
        }
        public String pop(){
            if(isEmpty()!=true){
                String test = this.first.data;
                this.first=this.first.prev;
                n--;
                return test;
            }
            else{
                return "ffff";
            }
        }
    }





    public static void main(String[] args){
    mystack test1 = new mystack();
    test1.push("dad");
    test1.push("2");
    test1.push("3");
    test1.push("4");
    String a =test1.pop();
    StdOut.println(a);
    a=test1.pop();
    StdOut.println(a);
    a=test1.pop();
    StdOut.println(a);
    a=test1.pop();
    StdOut.println(a);
    a=test1.pop();
    StdOut.println(a);
    }
}
