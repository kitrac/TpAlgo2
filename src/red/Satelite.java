package red;

import java.util.List;

public class Satelite extends Operador {

    private int velocidad;
    private int altura;
    private int diametroVisible;

    public Satelite(int id, int velocidad, int altura, int diametroVisible) {
        super(id);
        this.velocidad = velocidad;
        this.altura = altura;
        this.diametroVisible = diametroVisible;
    }

    public int getDiametroVisible() {
        return this.diametroVisible;
    }

    public int getAltura() {
        return this.altura;
    }


    public void mover(int largoOrbita) {
        this.setPosicion(this.getPosicion() + this.velocidad);
        if(this.getPosicion() > largoOrbita){
            this.setPosicion(0);
        }
        this.actualizarEstadoEdges();
    }

    public void actualizarEstadoEdges() {
        List<Edge> edges = this.getEdges();
        for (Edge arista : edges) {
            arista.setEstado(this.dentroRango(arista.getDestino().getPosicion()));
        }
    }

    private boolean dentroRango(int posicion) {
        return  this.getPosicion() - this.diametroVisible  < posicion && this.getPosicion() + this.diametroVisible > posicion;
    }


    @Override
    public String toString() {
        return "Satelite id = " + this.getId() + " altura = " + this.altura + " posicion = " + this.getPosicion() + " conexiones = " + this.getEdges() + "\n";
    }
}
