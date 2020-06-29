package mensaje;

import red.Edge;
import red.Operador;

import java.util.List;

public class InfoReply extends Mensaje{
    public InfoReply(String id, Operador origen, Operador destino, contenido.InfoReply contenido) {
        super(id + "-Reply", origen, destino, contenido);
    }

    @Override
    public void enviar() {
        Operador origen = this.getOrigen();
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado()) {
                contenido.InfoReply contenido = (contenido.InfoReply) this.getContenido();
                contenido.sumarDistancia(arista.getDistancia());
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
                contenido.InfoReply contenido = (contenido.InfoReply) this.getContenido();
                contenido.sumarDistancia(arista.getDistancia());
                arista.getDestino().recibirMensaje(this);
            }
        }
    }
}
