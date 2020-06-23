package mensaje;

import red.Edge;
import red.Operador;

import java.util.List;

public class PingReply extends Mensaje {
    private int latencia;

    public PingReply(String id, Operador origen, Operador destino, contenido.PingReply contenido, int latencia) {
        super(id + "Reply", origen, destino, contenido);
        this.latencia = latencia;
    }

    @Override
    public void enviar() {
        Operador origen = this.getOrigen();
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado()) {
                arista.getDestino().recibirMensaje(this);
            }
        }
    }

    @Override
    public void reenviarMensaje() {
        Operador origen = this.getOrigen();
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado()) {
                arista.getDestino().recibirMensaje(this);
            }
        }
    }

    @Override
    public String toString() {
        return "PingReply{" +
                "latencia=" + latencia +
                '}';
    }
}
