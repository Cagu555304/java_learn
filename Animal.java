
public class Animal {
    public static  class AninmAl{
        protected String  name;
        protected int age;
        public AninmAl(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public void speek() {
            StdOut.println("Animal makes a sound");
        }
    }


    public static class Cat extends AninmAl{
        public Cat(String name, int age) {
            super(name, age);
        }
        @Override
        public void speek() {
            StdOut.println(this.name+"mimi");
        }
    }

    public static void main(String[] args)
    { Cat cat = new Cat("cat",18);
        cat.speek();
    }
}
