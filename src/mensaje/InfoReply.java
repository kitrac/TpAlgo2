package mensaje;

import contenido.Contenido;
import exceptions.MensajeRepetidoException;
import red.Edge;
import red.Operador;
import java.util.List;

public class InfoReply extends Mensaje implements Cloneable {
    public InfoReply(String id, Operador origen, Operador destino, contenido.InfoReply contenido) {
        super(id, origen, destino, contenido);
    }

    @Override
    public void enviar() {
        Operador origen = this.getOrigen();
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado() && !this.getRecorrido().contains(arista.getDestino())) {
                contenido.InfoReply contenido = (contenido.InfoReply) this.getContenido();
                contenido.InfoReply contenidoCopiado = contenido.clone();
                contenidoCopiado.sumarDistancia(arista.getDistancia());
                InfoReply mensajeCopiado = this.clone(contenidoCopiado);
                arista.getDestino().recibirMensaje(mensajeCopiado);
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
                contenido.InfoReply contenidoCopiado = contenido.clone();
                contenidoCopiado.sumarDistancia(arista.getDistancia());
                InfoReply mensajeCopiado = this.clone(contenidoCopiado);
                arista.getDestino().recibirMensaje(mensajeCopiado);
            }
        }
    }

    public InfoReply clone(contenido.InfoReply contenido) {
        return new InfoReply(this.getId(), this.getOrigen(), this.getDestino(), contenido);
    }
}
