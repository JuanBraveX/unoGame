import java.util.List;

public class Jugador {
    // Atributos
    private String nombre;
    private Integer edad;
    public List<Carta> cartas;

    // Constructor
    public Jugador(String nombre, Integer edad, List<Carta> cartas) {
        this.nombre = nombre;
        this.edad = edad;
        this.cartas = cartas;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para edad
    public Integer getEdad() {
        return edad;
    }

    // Setter para edad con validación
    public void setEdad(Integer edad) {
        if (edad < 0) {
            System.out.println("La edad no puede ser negativa.");
        } else {
            this.edad = edad;
        }
    }

    // Método toString para representar el objeto como una cadena
    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", edad=" + edad + "]";
    }

    // Método para mostrar información del jugador
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }

    // Método para simular una acción del jugador (por ejemplo, jugar)
    public void jugar() {
        System.out.println(nombre + " está jugando...");
    }

}
