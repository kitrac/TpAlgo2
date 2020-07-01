package red;

import exceptions.IdOperadorDuplicadoException;
import mensaje.InfoReply;
import mensaje.InfoRequest;
import mensaje.PingReply;
import mensaje.PingRequest;

public class Comunicacion extends SateliteGeo {
    public Comunicacion(int id, int altura, int diametroVisible) throws IdOperadorDuplicadoException {
        super(id, altura, diametroVisible);
    }

    public Comunicacion(int id, int altura, int diametroVisible, int posicion) throws IdOperadorDuplicadoException {
        super(id, altura, diametroVisible, posicion);
    }

    @Override
    public void recibirMensaje(PingRequest mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            PingReply respuesta = new PingReply(mensaje.getId(), this, mensaje.getCreador(), new contenido.PingReply(0, true));
            this.enviarMensaje(respuesta);
            this.addMensajeSalida(mensaje);
        } else if (mensaje.getContenido().getReenvio()) {
            mensaje.setOrigen(this);
            mensaje.addOperadorRecorrido(this);
            this.addMensajeSalida(mensaje);
            this.reenviarMensaje(mensaje);
        }
        this.addMensajeEntrada(mensaje);
    }

    @Override
    public void recibirMensaje(PingReply mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            System.out.println(mensaje.getContenido());
        } else if (mensaje.getContenido().getReenvio()) {
            mensaje.setOrigen(this);
            mensaje.addOperadorRecorrido(this);
            this.addMensajeSalida(mensaje);
            this.reenviarMensaje(mensaje);

        }
        this.addMensajeEntrada(mensaje);
    }

    @Override
    public void recibirMensaje(InfoRequest mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            InfoReply respuesta = new InfoReply(mensaje.getId(), this, mensaje.getCreador(), new contenido.InfoReply(true, this.getId(), 0));
            this.enviarMensaje(respuesta);
            this.addMensajeSalida(mensaje);
        } else if (mensaje.getContenido().getReenvio()) {
            mensaje.setOrigen(this);
            mensaje.addOperadorRecorrido(this);
            this.reenviarMensaje(mensaje);
        }
        this.addMensajeEntrada(mensaje);
    }

    @Override
    public void recibirMensaje(InfoReply mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            System.out.println(mensaje.getContenido());
        } else if (mensaje.getContenido().getReenvio()) {
            mensaje.setOrigen(this);
            mensaje.addOperadorRecorrido(this);
            this.reenviarMensaje(mensaje);
        }
        this.addMensajeEntrada(mensaje);
    }

    public void reenviarMensaje(PingRequest mensaje) {
        mensaje.reenviarMensaje();
        this.addMensajeSalida(mensaje);
    }

    public void reenviarMensaje(PingReply mensaje) {
        mensaje.reenviarMensaje();
        this.addMensajeSalida(mensaje);
    }

    public void reenviarMensaje(InfoRequest mensaje) {
        mensaje.reenviarMensaje();
        this.addMensajeSalida(mensaje);
    }

    public void reenviarMensaje(InfoReply mensaje) {
        mensaje.reenviarMensaje();
        this.addMensajeSalida(mensaje);
    }
}
