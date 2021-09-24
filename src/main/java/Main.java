import collections.MyArrayList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        linkedListJava();
        arrayListJava();
        myArrayList();
        myLinkedList();
    }

    public static void linkedListJava() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;

        linkedList.add(a);
        linkedList.add(b);
        linkedList.add(c);

        System.out.println("LinkedList:");
        linkedList.forEach(System.out::println);
        System.out.println("Get index of element:");
        System.out.println(linkedList.indexOf(b));
        System.out.println("Remove element");
        linkedList.remove(b);
        linkedList.forEach(System.out::println);
    }

    public static void arrayListJava() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;

        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);

        System.out.println("ArrayList:");
        arrayList.forEach(System.out::println);
        System.out.println("Get index of element:");
        System.out.println(arrayList.indexOf(a));
        System.out.println("Remove element");
        arrayList.remove(b);
        arrayList.forEach(System.out::println);
    }

    public static void myArrayList() {
        MyArrayList<Integer> myList = new MyArrayList<>();
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;

        myList.add(a);
        myList.add(b);
        myList.add(c);

        System.out.println("MyArrayList");
        myList.print();
        System.out.println("Get index of element:");
        System.out.println(myList.indexOf(c));
        int index = myList.indexOf(b);
        System.out.println("Remove element with index " + index);
        myList.remove(b);
        myList.print();
    }

    public static void myLinkedList() {

    }
}
