package test;

class A {
    public String show(D obj) {
        return ("A and D");
    }
    public String show(A obj) {
        return ("A and A");
    }
}
// 
class B extends A {
    public String show(B obj) {
        return ("B and B");
    }
    public String show(A obj) {
        return ("B and A");
    }
}
// 
class C extends B {
}
// 
class D extends B {
}
class PolymorphicTest {
    //https://jums.club/java-polymorphism/
    //this 为编译型
    //调用优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)
    public static void main(String[] args) {
        A a = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("1 " + a.show(b));//A and A
        System.out.println("2 " + a.show(c));//A and A
        System.out.println("3 " + a.show(d));//A and D

        System.out.println("4 " + a2.show(b));//B and A （***）
        System.out.println("5 " + a2.show(c));//B and A （***）
        System.out.println("6 " + a2.show(d));//A and D

        System.out.println("7 " + b.show(b));//B and B
        System.out.println("8 " + b.show(c));//B and B
        System.out.println("9 " + b.show(d));//A and D
    }
}
