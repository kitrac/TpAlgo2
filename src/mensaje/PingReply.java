package mensaje;

import red.Edge;
import red.Operador;

import java.util.List;

public class PingReply extends Mensaje {

    public PingReply(String id, Operador origen, Operador destino, contenido.PingReply contenido) {
        super(id + "Reply", origen, destino, contenido);
    }

    @Override
    public void enviar() {
        Operador origen = this.getOrigen();
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado()) {
                contenido.PingReply contenido = (contenido.PingReply) this.getContenido();
                contenido.sumarLatencia((int) arista.getDistancia());
                arista.getDestino().recibirMensaje(this);
            }
        }
    }

    @Override
    public void reenviarMensaje() {
        Operador origen = this.getOrigen();
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado() && !this.getRecorrido().contains(arista.getDestino())) {
                contenido.PingReply contenido = (contenido.PingReply) this.getContenido();
                contenido.sumarLatencia((int) arista.getDistancia());
                arista.getDestino().recibirMensaje(this);
            }
        }
    }
}
