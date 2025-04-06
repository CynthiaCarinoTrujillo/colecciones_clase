package Ejercicio12_37;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author cyn
 */
public class PlantillaEquipo {

    //declaracion de map que recibira un jugador y la dorsal que es unico
   private static Map<Integer, Jugador> plantillaJugadores = new HashMap<Integer, Jugador>();

    public static void altaJugador(Integer dorsal, Jugador jugador) {
        //añade una entrada al mapa con el dorsal y el jugador creado dentro del metodo
        plantillaJugadores.put(dorsal, jugador);
    }

    //recibe un dorsal que se va a eliminar, el cual corresponde al jugador
    //el metodo devuelve el jugador eliminado
    public static Jugador eliminarJugador(Integer dorsal) {
        plantillaJugadores.remove(dorsal);
        Jugador eliminado = plantillaJugadores.get(dorsal);
        return eliminado;
    }

    //muestra una lista de los dorsales con el nombre de los jugadores
    public static void mostrar() {
        for (Map.Entry<Integer, Jugador> valores : plantillaJugadores.entrySet()) {
            System.out.println("Dorsal: " + valores.getKey() + " Nombre del jugador:" + valores.getValue().getNombreJugador());
        }
    }

    public static void mostrarMismaPosicion(String posicion) {
        //muestra una lista de jugadores que comparten la misma posicion
        //recibe el nombre de la posicion de la que se mostraran los datos de los jugadores
        //todos los defensa
        for (Map.Entry<Integer, Jugador> valores : plantillaJugadores.entrySet()) {
            //si la posicion indicada es igual al valor y posicion al iterarse, se imprime
            if (valores.getValue().getPosicionJugador() == posicion) {
                System.out.println("Dorsal: " + valores.getKey() + ", Nombre: " + valores.getValue().getNombreJugador());

            }
        }

    }

    public static boolean editarJugador(Integer dorsal) { //recibe la dorsal del jugador
        /*permite modificar datos de un jugador excepto su dorsal y dni. devuelve true
     si el dorsal existe false en caso de que la dorsal no exista*/
        Scanner entradaDatos=new Scanner(System.in);
        boolean existe = true;
        if (plantillaJugadores.containsKey(dorsal) == false) {
            existe = false;//El dorsal no existe, no se puede editar
        } else {
            //se encontro la dorsal ahora debemos editar los datos del jugador
            Jugador jugador=plantillaJugadores.get(dorsal);
            //debemos editar la posicion, nombre del jugador, estatura
            System.out.println("Ingrese el nombre del jugador a modificar");
            String modificacion=entradaDatos.nextLine().trim();
            jugador.setNombreJugador(modificacion);
            
            System.out.println("Ingrese la posicion del jugador");
            modificacion=entradaDatos.nextLine().trim();
            jugador.setPosicionJugador(modificacion);
            
            System.out.println("Ingrese la estatura del jugador");
            double nuevaEstatura=entradaDatos.nextDouble();
            jugador.setEstatura(nuevaEstatura);
            
            existe = true;
        }

        return existe;
    }
}
