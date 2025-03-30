
package Ejercicio12_33;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author cyn
 */
public class Prueba {
    
    public static void main(String[] args) {
        // Prueba con orden natural (String implementa Comparable)
        ListaOrdenada<String> listaNatural = new ListaOrdenada<>();
        listaNatural.add("banana");
        listaNatural.add("apple");
        listaNatural.add("cherry");
        listaNatural.add("apple"); // Permitimos repeticiones
        System.out.println("Lista con orden natural: " + listaNatural);
        // Salida esperada: [apple, apple, banana, cherry]

        // Prueba con un Comparator personalizado (orden descendente)
        Comparator<String> ordenDescendente = (s1, s2) -> s2.compareTo(s1);
        ListaOrdenada<String> listaConComparator = new ListaOrdenada<>(ordenDescendente);
        listaConComparator.add("banana");
        listaConComparator.add("apple");
        listaConComparator.add("cherry");
        listaConComparator.add("apple");
        System.out.println("Lista con Comparator (descendente): " + listaConComparator);
        // Salida esperada: [cherry, banana, apple, apple]
    }
}

