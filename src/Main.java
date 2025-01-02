import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cantidadCartas;
        while (true) {
            System.out.print("Cantidad de cartas: ");
            cantidadCartas = sc.nextInt();
            if (cantidadCartas % 4 == 0) {
                System.out.println("Cantidad válida: " + cantidadCartas);
                break;
            } else {
                System.out.println("Error: La cantidad debe ser un múltiplo de 4.");
            }
        }

        int jugadores = 2;
        Mesa mesa = new Mesa();
        List<Carta> lstCartas = mesa.barajear(cantidadCartas);
        List<List<Carta>> manos = dividirCartas(lstCartas, jugadores);
        Jugador jugador = new Jugador("Juan", 18, manos.get(0));
        Jugador bot = new Jugador("BOTMaster", 18, manos.get(1));

        System.out.println("Mano del " + jugador);
        lstCartas = new ArrayList<>();
        for (Carta mano : manos.get(0)) {
            System.out.print(mano.toString() + " ");
        }
        System.out.println("\nMano del " + bot);
        for (Carta mano : manos.get(1)) {
            System.out.print(mano.toString() + " ");
        }
        Carta carta = new Carta(null, null);

        while (true) {
            try {
                System.out.println("\n" + "¿Cuál carta bajas?");
                int valorEntrada = sc.nextInt() - 1;

                // Validar el índice ingresado
                if ((valorEntrada == -1 && lstCartas.isEmpty()) || valorEntrada < -1 || valorEntrada >= manos.get(0).size()) {
                    System.out.println("Índice inválido, intenta de nuevo.");
                    continue;
                }
                if (valorEntrada == -1) {
                    System.out.println("Jugador pasa.");
                } else {
                    // Juega la carta del jugador
                    carta = manos.get(0).get(valorEntrada);
                    if (lstCartas.isEmpty() || carta.getColor() == mesa.carta.getColor() || carta.getNumero().equals(mesa.carta.getNumero())) {
                        lstCartas.add(carta);
                        manos.get(0).remove(valorEntrada); // Remover la carta seleccionada
                        mesa.asignarJugada(jugador, carta);
                    } else {
                        System.out.println("Carta invalida, intenta de nuevo.");
                        continue;
                    }
                    if (manos.get(0).isEmpty()) {
                        System.out.print("Jugador Ganador");
                        break;
                    }
                }


                // Juega el bot
                int valorBot = botPlayer(carta, manos.get(1));
                if (valorBot >= 0) { // Si encuentra una carta válida
                    Carta cartaBot = manos.get(1).get(valorBot);
                    mesa.asignarJugada(bot, cartaBot);
                    lstCartas.add(cartaBot);
                    manos.get(1).remove(valorBot); // Remover la carta jugada por el bot
                }
                if (manos.get(1).isEmpty()) {
                    System.out.print("Jugador Bot Ganador");
                    break;
                }
                System.out.println("Mesa actual: " + mesa);
                System.out.print("Cartas del jugador: ");
                for (Carta mano : manos.get(0)) {
                    System.out.print(mano.toString() + " ");
                }
                System.out.println();

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine(); // Limpiar el buffer del escáner
            }
        }
    }

    public static int botPlayer(Carta carta, List<Carta> lstCarta) {
        for (int i = 0; i < lstCarta.size(); i++) {
            Carta cartaV = lstCarta.get(i);
            if (carta.getColor() == cartaV.getColor() || carta.getNumero().equals(cartaV.getNumero())) {
                return i; // Devuelve el índice si la carta cumple alguna condición
            }
        }
        return -1; // Devuelve -1 si no hay carta válida
    }

    public static List<List<Carta>> dividirCartas(List<Carta> lista, int jugadores) {
        List<List<Carta>> resultado = new ArrayList<>();
        int tamanoParte = lista.size() / jugadores;
        int sobrante = lista.size() % jugadores;

        int inicio = 0;
        for (int i = 0; i < jugadores; i++) {
            int fin = inicio + tamanoParte + (i < sobrante ? 1 : 0);
            resultado.add(new ArrayList<>(lista.subList(inicio, fin))); // Crear nueva lista para evitar conflictos
            inicio = fin;
        }
        return resultado;
    }
}
