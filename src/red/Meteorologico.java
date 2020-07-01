package red;

import exceptions.IdOperadorDuplicadoException;
import mensaje.InfoReply;
import mensaje.InfoRequest;
import mensaje.PingReply;
import mensaje.PingRequest;

public class Meteorologico extends Satelite {
    public Meteorologico(int id, int velocidad, int altura, int diametroVisible) throws IdOperadorDuplicadoException {
        super(id, velocidad, altura, diametroVisible);
    }

    public void recibirMensaje(PingRequest mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            PingReply respuesta = new PingReply(mensaje.getId(), this, mensaje.getCreador(), new contenido.PingReply(0,true));
            mensaje.addOperadorRecorrido(this);
            this.enviarMensaje(respuesta);
            this.addMensajeSalida(mensaje);
        }
        this.addMensajeEntrada(mensaje);
    }

    public void recibirMensaje(PingReply mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            System.out.println(mensaje.getContenido());
        }
        this.addMensajeEntrada(mensaje);
    }

    @Override
    public void recibirMensaje(InfoRequest mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            InfoReply respuesta = new InfoReply(mensaje.getId(), this, mensaje.getCreador(), new contenido.InfoReply(true, this.getId(), 0));
            mensaje.addOperadorRecorrido(this);
            this.enviarMensaje(respuesta);
            this.addMensajeSalida(mensaje);
        }
        this.addMensajeEntrada(mensaje);
    }

    @Override
    public void recibirMensaje(InfoReply mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            System.out.println(mensaje.getContenido());
        }
        this.addMensajeEntrada(mensaje);
    }
}
