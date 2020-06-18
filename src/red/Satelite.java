package red;

public class Satelite extends Operador {

    private int posicion; //posicion en la orbita
    private int velocidad;
    private int altura;

    public Satelite(int id, int velocidad, int altura) {
        super(id);
        this.velocidad = velocidad;
        this.altura = altura;
    }

    public void setPosicion(int largoOrbita) {
        this.posicion = (int) (Math.random() * largoOrbita);
    }

    public int getPosicion() {
        return this.posicion;
    }

    public int getAltura() {
        return this.altura;
    }

    public void mover() {
        this.posicion = this.posicion + this.velocidad;
    }


    @Override
    public String toString() {
        return "Satelite posicion = " + posicion + " " + super.toString();
    }
}
