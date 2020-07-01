package red;

import exceptions.IdOperadorDuplicadoException;
import exceptions.PosicionOperadorException;
import mensaje.*;

public class Estacion extends Operador {

    public Estacion(int id, int largoTierra) throws IdOperadorDuplicadoException {
        super(id, 0);
        this.setPosicionInicialRandom(largoTierra);
    }

    public Estacion(int id, int posicion, int largoTierra) throws IdOperadorDuplicadoException, PosicionOperadorException {
        super(id, 0);
        if (posicion >= 0 && posicion <= largoTierra) {
            this.setPosicion(posicion);
        } else {
            throw new PosicionOperadorException("Error posicion estacion: " + this.getId());
        }
    }


    @Override
    public void recibirMensaje(PingRequest mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            PingReply respuesta = new PingReply(mensaje.getId(), this, mensaje.getCreador(), new contenido.PingReply(0));
            mensaje.addOperadorRecorrido(this);
            this.enviarMensaje(respuesta);
            this.addMensajeSalida(mensaje);
        }
        this.addMensajeEntrada(mensaje);
    }

    @Override
    public void recibirMensaje(PingReply mensaje) {
        if (mensaje.getDestino().getId() == this.getId()) {
            System.out.println(mensaje.getContenido() + " Origen: " + mensaje.getOrigen().getId());
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

    public void addEdge(Satelite destino) {
        Edge arista = new Edge(this, destino, destino.getAltura());
        this.getEdges().add(arista);

        Edge aristaVuelta = new Edge(destino, this, destino.getAltura());
        destino.getEdges().add(aristaVuelta);
    }

    public void addEdge(Estacion destino) {

        int distancia = Math.abs(destino.getPosicion() - this.getPosicion());
        Edge arista = new Edge(this, destino, distancia);
        this.getEdges().add(arista);
        Edge aristaVuelta = new Edge(destino, this, distancia);
        destino.getEdges().add(aristaVuelta);
    }


    @Override
    public String toString() {
        return "Estacion id = " + this.getId() + " conexiones = " + this.getEdges() + "\n";
    }
}
