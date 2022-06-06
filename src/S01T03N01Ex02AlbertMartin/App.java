package S01T03N01Ex02AlbertMartin;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class App {
    public static void main(String[] args) {

    //Creem la primera List<Integer> i la mostrem per pantalla.
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);

        System.out.println("\nPrimera List<Integer>:");
        for (Integer integer : list1) {
            System.out.println(integer);
            }

    //Creem la segona List<Integer> i la mostrem per pantalla.
        List<Integer> list2 = new ArrayList<Integer>();

        ListIterator<Integer> it = list1.listIterator(list1.size());
        while (it.hasPrevious())
            list2.add(it.previous());

        System.out.println("\nSegona List<Integer>:");
        for (Integer integer : list2) {
            System.out.println(integer);
            }

    }
}