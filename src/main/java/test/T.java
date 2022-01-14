package test;

public class T { //1
    public static void main(String[] args) {
        new T(); //4
        //
        System.out.println("done..");
        T.run();
    }

    static int num = 4; //2.

    static {
        System.out.println("num:" + num); // 3.a
        System.out.println("a");
    }

    {
        num += 3;
        System.out.println("b:" + num); //5.
    }

    int a = 5; //6.

    { //
        System.out.println("c:" + a); //7.c
    }

    T() { //
        System.out.println("d"); //8.
    }

    static void run() {
        System.out.println("e");
    }
}