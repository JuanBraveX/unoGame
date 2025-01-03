public class Carta {
   private Colores color;
   private Integer numero;

    public Carta(Colores color, Integer numero) {
        this.color = color;
        this.numero = numero;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "["+color+" "+numero+"]";
    }
}
