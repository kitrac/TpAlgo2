package red;

import mensaje.PingReply;
import mensaje.PingRequest;

public class Meteorologico extends Satelite{
    public Meteorologico(int id, int velocidad, int altura, int diametroVisible) {
        super(id, velocidad, altura, diametroVisible);
    }

    public void recibirMensaje(PingRequest mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            PingReply respuesta = new PingReply(mensaje.getId(), this, mensaje.getCreador(), new contenido.PingReply(0));
            this.enviarMensaje(respuesta);
        } else if (mensaje.getContenido().getReenvio()) {
            mensaje.setOrigen(this);
            mensaje.addOperadorRecorrido(this);
            this.reenviarMensaje(mensaje);
        }
        this.getConsola().add(mensaje);
    }

    public void recibirMensaje(PingReply mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            System.out.println(mensaje.getContenido());
        } else if (mensaje.getContenido().getReenvio()) {
            mensaje.setOrigen(this);
            mensaje.addOperadorRecorrido(this);
            this.reenviarMensaje(mensaje);

        }
        this.getConsola().add(mensaje);
    }
}
