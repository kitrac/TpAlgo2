package mensaje;

import red.Edge;
import red.Operador;

import java.util.List;

public class PingReply extends Mensaje implements Cloneable{

    public PingReply(String id, Operador origen, Operador destino, contenido.PingReply contenido) {
        super(id, origen, destino, contenido);
    }

    @Override
    public void enviar() {
        Operador origen = this.getOrigen();
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado() && !this.getRecorrido().contains(arista.getDestino())) {
                contenido.PingReply contenido = (contenido.PingReply) this.getContenido();
                contenido.PingReply contenidoNuevo = new contenido.PingReply(contenido.getLatencia(),true);
                contenidoNuevo.sumarLatencia((int) arista.getDistancia());
                PingReply mensajeCopia = this.clone(contenidoNuevo);
                arista.getDestino().recibirMensaje(mensajeCopia);
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
                contenido.PingReply contenidoNuevo = new contenido.PingReply(contenido.getLatencia(),true);
                contenidoNuevo.sumarLatencia((int) arista.getDistancia());
                PingReply mensajeCopia = this.clone(contenidoNuevo);
                arista.getDestino().recibirMensaje(mensajeCopia);
            }
        }
    }

    public PingReply clone(contenido.PingReply contenido) {
        return new PingReply(this.getId(), this.getOrigen(), this.getDestino(), contenido);
    }
}
