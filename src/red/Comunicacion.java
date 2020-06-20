package red;

import mensaje.PingReply;
import mensaje.PingRequest;

public class Comunicacion extends SateliteGeo {
    public Comunicacion(int id, int altura, int diametroVisible) {
        super(id, altura, diametroVisible);
    }


    public void recibirMensaje(PingRequest mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            System.out.println(mensaje);
        } else if (mensaje.getContenido().getReenvio()) {
            mensaje.setOrigen(this);
            PingReply respuesta = new PingReply(mensaje.getId(), this, mensaje.getCreador(), new contenido.PingReply(0), 0);
            Operador.enviarMensaje(respuesta);
        }
        this.getConsola().add(mensaje);
    }
}
