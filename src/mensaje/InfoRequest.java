package mensaje;

import exceptions.MensajeRepetidoException;
import red.Edge;
import red.Operador;

import java.util.List;

public class InfoRequest extends Mensaje {
    public InfoRequest(String id, Operador origen, Operador destino){
        super(id, origen, destino);
    }

    @Override
    public void enviar() {
        Operador origen = this.getOrigen();
        origen.addMensajeSalida(this);
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado() && !this.getRecorrido().contains(arista.getDestino())) {
                arista.getDestino().recibirMensaje(this);
            }
        }
    }

    @Override
    public void reenviarMensaje() {
        Operador origen = this.getOrigen();
        origen.addMensajeSalida(this);
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado() && !this.getRecorrido().contains(arista.getDestino())) {
                arista.getDestino().recibirMensaje(this);
            }
        }
    }
}
