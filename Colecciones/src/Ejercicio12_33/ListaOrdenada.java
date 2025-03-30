
package Ejercicio12_33;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author cyn
 */

// La clase es genérica con tipo E, que debe implementar Comparable<E> si se usa el orden natural
public class ListaOrdenada<E extends Comparable<E>> {
    // Lista interna para almacenar los elementos
    private List<E> elementos;
    // Comparator para definir un criterio de orden personalizado (puede ser null)
    private Comparator<E> comparator;

    // Constructor que usa el orden natural de E
    public ListaOrdenada() {
        this.elementos = new ArrayList<>();
        this.comparator = null; // No se usa Comparator, se usará el orden natural
    }

    // Constructor que acepta un Comparator para un orden personalizado
    public ListaOrdenada(Comparator<E> comparator) {
        this.elementos = new ArrayList<>();
        this.comparator = comparator; // Usar el Comparator proporcionado
    }

    // Método para agregar un elemento, manteniendo el orden
    public void add(E elemento) {
        // Encontrar la posición donde insertar el elemento para mantener el orden
        int posicion = 0;
        for (E actual : elementos) {
            // Comparar usando el Comparator si existe, o el orden natural si no
            int comparacion;
            if (comparator != null) {
                comparacion = comparator.compare(actual, elemento);
            } else {
                comparacion = actual.compareTo(elemento);
            }

            // Si el elemento actual es mayor que el nuevo elemento, insertamos aquí
            if (comparacion > 0) {
                break;
            }
            posicion++;
        }

        // Insertar el elemento en la posición encontrada
        elementos.add(posicion, elemento);
    }

    // Método para obtener un elemento en un índice dado
    public E get(int index) {
        if (index < 0 || index >= elementos.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return elementos.get(index);
    }

    // Método para obtener el tamaño de la lista
    public int size() {
        return elementos.size();
    }

    // Método toString para mostrar la lista
    @Override
    public String toString() {
        return elementos.toString();
    }
}
