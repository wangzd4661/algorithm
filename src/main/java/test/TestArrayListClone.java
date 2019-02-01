package test;

import java.util.ArrayList;

public class TestArrayListClone {
    public static void main(String[] args) {
        Person p1 = new Person("w", 10);
        Person p2 = new Person("s", 12);
        ArrayList<Person> list1 = new ArrayList<>();
        list1.add(p1);
        list1.add(p2);

        ArrayList<Person> list2 = (ArrayList<Person>) list1.clone();
        p1.age=100;
        for (Person person : list1) {
            System.out.println("list1"+ "\t"+"name:" + person.name + "\t" + "age:" + person.age);
        }
        for (Person person : list2) {
            System.out.println("list2"+ "\t"+"name:" + person.name + "\t" + "age:" + person.age);
        }
    }

    static class Person implements Cloneable {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
