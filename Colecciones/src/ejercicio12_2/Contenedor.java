package ejercicio12_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author cyn
 */
public class Contenedor<T extends Comparable<T>> {

    //array de T
    private T array[];
    private List<T> listaT;

    public Contenedor(T[] tabla) {
//        this.array = (T[]) new Object[0];
        //inicializa un array de genericos, el new objeto hace casting con el array de tipo T
        this.array=tabla;
        listaT=new ArrayList<>();
    }
    
    //constructor que inicializa un array con longitud de 30
//    public Contenedor(T cantidad){
//        this.array=(T[]) new Object[30];
//    }

    void insertarAlInicio(T nuevo) {
        // modificar longitud para insertar un nuevo elemento
        T arraycopia[] = Arrays.copyOf(array, array.length + 1);
        // hacer hueco en el indice 0
        System.arraycopy(array, 0, arraycopia, 1, array.length);
        arraycopia[0] = nuevo;

        array = Arrays.copyOf(arraycopia, arraycopia.length);
    }

    void insertarAlFinal(T nuevo) {
        // Crear una nueva copia del array con una longitud mayor 
        T arraycopia[] = Arrays.copyOf(array, array.length + 1);
        // Insertar el nuevo elemento al final
        arraycopia[array.length] = nuevo;
        array = Arrays.copyOf(arraycopia, arraycopia.length);
    }
    
    
    void rellenarArray() {
    // Comprobar que el array tiene espacio disponible
    Random random = new Random();
    for (int i = 0; i < array.length; i++) {
        // Generar un valor aleatorio y asignarlo
        array[i] = (T) Integer.valueOf(random.nextInt(101)); // Números aleatorios entre 0 y 100
    }
}
 

    void eliminarAlInicio() {
        //comprobar que el array no este vacio, si la longitud es 0 esta vacio
        if (array.length == 0) {
            System.out.println("Array vacio");
        } else {
            //crear una nueva copia del array que comienza desde el índice 1 y termina en el índice array.length
            T arraycopia[] = Arrays.copyOfRange(array, 1, array.length);
            array = Arrays.copyOf(arraycopia, arraycopia.length);
        }
    }

    void eliminarDelFinal() {
        if (array.length == 0) {
            System.out.println("Array vacío");
        } else {
            array= Arrays.copyOf(array, array.length - 1);
        }
    }
    
   
    @Override
    public String toString() {
        return "Contenedor{" + "array=" + array + '}';
    }
    
    public void ordenar() {
        Arrays.sort(array);  // Usamos Arrays.sort para ordenar el array
    }
    
    public void mostrarInformacion(){
        for (T valor: array){
            System.out.println(valor);
        }
    }
    
    
    public int[] buscarTodos(Object e){
    //devuelve una tabla con los indices de las ocurrencias de e 
        List<Integer> tablaIndices=new ArrayList<>(); //guardara los indices
        
        //debemos buscar los indices en el arraylist
        for (int contador=0; contador < listaT.size();contador++){
            if (e != null && e == listaT.get(contador)){
                tablaIndices.add(contador);
            }
        }
        
        //convertir arraylist a array
        int t1[]= new int[tablaIndices.size()]; //se crea un array int con la longitud del arraylist
        //recorremos el array para asignar los valores del arraylist
        for (int contador=0; contador < tablaIndices.size();contador++){
            //se van copiando de la tablaindices a la tabla t1
            t1[contador]=tablaIndices.get(contador);
        }
        
        return t1;
    }
    
    
    public <T> List<T> eliminaRepetidos(List<T> lista){
        //recibe una lista con elementos repetidos y devuelve otra lista eliminando los repetidos
        //se crea una variable set que eliminara los elementos repetidos de la lista
        Set<T> conjuntoSinrepetir=new LinkedHashSet<>(lista);
        //despues a lista se le asigna el conjunto SIN ELEMENTOS REPETIDOS
        lista=new ArrayList<>(conjuntoSinrepetir);
        return lista;
    }
    
    //metodo que elimina las ocurrencias de e devuelve true si la lista queda alterada
    boolean eliminarTodos(Object e){
        boolean resultado=listaT.remove(e);
        return resultado;
    }
    
    
    
    
    
}
