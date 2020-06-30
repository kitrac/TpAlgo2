package mensaje;

import contenido.Contenido;
import red.Edge;
import red.Operador;

import javax.sound.sampled.Line;
import java.util.List;

public class InfoReply extends Mensaje implements Cloneable {
    public InfoReply(String id, Operador origen, Operador destino, contenido.InfoReply contenido) {
        super(id + "-Reply", origen, destino, contenido);
    }

    @Override
    public void enviar() {
        Operador origen = this.getOrigen();
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado()) {
                InfoReply mensajeCopiado = this.clone();
                contenido.InfoReply contenido = (contenido.InfoReply) this.getContenido();
                contenido.InfoReply contenidoCopiado = contenido.clone();
                contenidoCopiado.sumarDistancia(arista.getDistancia());
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
                contenido.sumarDistancia(arista.getDistancia());
                InfoReply mensajeCopiado = this.clone();
                arista.getDestino().recibirMensaje(mensajeCopiado);
            }
        }
    }

    @Override
    public InfoReply clone() {
        return new InfoReply(this.getId(), this.getOrigen(), this.getDestino(), (contenido.InfoReply) this.getContenido());
    }
}
