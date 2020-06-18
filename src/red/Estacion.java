package red;

import mensaje.Mensaje;
import orbitas.Orbita;

public class Estacion extends Operador {

    private int maximoRango;
    private int minimoRango;

    public Estacion(int id, int maximoRango, int minimoRango) {
        super(id);

        if(Orbita.getMaximoLargo() < maximoRango && Orbita.getMinimoLargo() > minimoRango){
            this.maximoRango = maximoRango;
            this.minimoRango = minimoRango;
        }else{
            //aca iria un error
        }
    }

    public Mensaje generarMensaje(int id, Operador destino, String contenido) {
        return new Mensaje(id, this, destino, contenido);
    }

    public void addEdge(Satelite destino) {
        Edge arista = new Edge(this, destino, destino.getAltura());
        this.getEdges().add(arista);
    }

    @Override
    public String toString() {
        return "Estacion " + super.toString();
    }
}
