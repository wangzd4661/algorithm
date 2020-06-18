package test;

public class Test {
    private int a=1;
    private static int c=1;
    public static void main(String[] args) {
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        ClassLoader ext=classLoader.getParent();
        System.out.println(ext);
        ClassLoader p2=ext.getParent();
        System.out.println(p2);
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
        ClassLoader classLoader2 = Test.class.getClassLoader();
        System.out.println(classLoader2);
    }
}
