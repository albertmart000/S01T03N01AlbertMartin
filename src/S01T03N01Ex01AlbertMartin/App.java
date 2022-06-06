package S01T03N01Ex01AlbertMartin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class App {

    public static void main(String[] args) {

    //Construim l'ArraysList sense l'objete amb l'atribut "Agost" i la mostrem per pantalla.

        List<Month> monthArrayList = new ArrayList<>();

        monthArrayList.add(new Month("Gener"));
        monthArrayList.add(new Month("Febrer"));
        monthArrayList.add(new Month("Mars"));
        monthArrayList.add(new Month("Abril"));
        monthArrayList.add(new Month("Maig"));
        monthArrayList.add(new Month("Juny"));
        monthArrayList.add(new Month("Juliol"));
        monthArrayList.add(new Month("Setembre"));
        monthArrayList.add(new Month("Octubre"));
        monthArrayList.add(new Month("Novembre"));
        monthArrayList.add(new Month("Decembre"));

        System.out.println("\nList<Month> monthArrayList sense l'atribut Agost:");
        for (Month month : monthArrayList) {
            System.out.print(month.getName() + " - ");
        }

    //Afegim l'objecte amb l'atribut Agost al seu lloc.

        System.out.println("\n\nList<Month> monthArrayList amb l'atribut Agost al seu lloc:");
        Month month8 = new Month("Agost");
        monthArrayList.add(7, month8);

        for (Month month : monthArrayList) {
            System.out.print(month.getName() + " - ");
        }

    //Convertim l'ArrayList anterior en un HashSet.

        System.out.println("\n\nHashSet<Month> monthHashSet:");
        HashSet<Month> monthHashSet = new HashSet<>(monthArrayList);

        for (Month month : monthHashSet) {
            System.out.print(month.getName() + " - ");
            }

    //Dupliquem l'objecte amb l'atribut Agost al HashSet, pero només es mostra en pantalla una vegada.

        System.out.println("\n\nHashSet<Month> monthHashSet sense l'objete amb l'atribut Agost duplicat:");
        monthHashSet.add(month8);
        for (Month month : monthHashSet) {
            System.out.print(month.getName() + " - ");
        }

        //Finalment, recorreguem l'ArrayList amb un iterator.

        System.out.println("\n\nList<Month> monthArrayList recorregut amb un iterator:");

        Iterator <Month> it = monthArrayList.iterator();
        while (it.hasNext()){
            System.out.print(it.next().getName() + " - ");
            }

    }
}


