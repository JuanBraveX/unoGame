import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Mesa {
    public Jugador jugador;
    public Carta carta;
    private List<Carta> cartas;

    public Mesa() {
        this.jugador = null;
        this.carta = null;
    }

    // Método para asignar un jugador a la mesa
    public void asignarJugada(Jugador jugador, Carta carta) {
        this.jugador = jugador;
        this.carta = carta;
    }

    @Override
    public String toString() {
        return "Movimento: "+jugador.getNombre()+" Carta: "+ carta.toString();
    }

    public List<Carta> barajear(int cantidadCartas){

        // Validamos que la cantidad sea múltiplo de 4
        if (cantidadCartas % 4 != 0) {
            throw new IllegalArgumentException("La cantidad de colores debe ser un múltiplo de 4.");
        }
        cantidadCartas= cantidadCartas/4;
        cartas = new ArrayList<>();
        for (int i = 1; i<=cantidadCartas; i++){
            System.out.println(i);
            cartas.add(new Carta(Colores.AZUL,i));
            cartas.add(new Carta(Colores.AMARILLO,i));
            cartas.add(new Carta(Colores.ROJO,i));
            cartas.add(new Carta(Colores.VERDE,i));
        }
        // Revolvemos la lista para que los colores se distribuyan al azar
        Collections.shuffle(cartas);
        return cartas;
    }


}
