package Ejercicio12_37;

/**
 *
 * @author cyn
 */
public class Jugador {

    enum posicion {
        PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO
    }

    private String nombreJugador;
    private String dniJugador;
    private posicion posicionJugador;
    private double estatura;

    public Jugador(String nombreJugador, String dniJugador, String posicionJugador,double estatura) {
        this.nombreJugador = nombreJugador;
        this.dniJugador = dniJugador;
        this.posicionJugador = posicion.valueOf(posicionJugador.toUpperCase());
        this.estatura=estatura;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getDniJugador() {
        return dniJugador;
    }

    public void setDniJugador(String dniJugador) {
        this.dniJugador = dniJugador;
    }

    public String getPosicionJugador() {
        String posicion=String.valueOf(posicionJugador);
        return posicion;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicionJugador = posicion.valueOf(posicionJugador.toUpperCase());
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    @Override
    public String toString() {
        return "Jugador{" + nombreJugador + ", DNI= " + dniJugador + ", Posicion= " + posicionJugador + ", estatura= " + estatura + '}';
    }

}
