package red;

import mensaje.InfoReply;
import mensaje.InfoRequest;
import mensaje.PingReply;
import mensaje.PingRequest;

public class Meteorologico extends Satelite{
    public Meteorologico(int id, int velocidad, int altura, int diametroVisible) {
        super(id, velocidad, altura, diametroVisible);
    }

    public void recibirMensaje(PingRequest mensaje) {

    }

    public void recibirMensaje(PingReply mensaje) {
    }

    @Override
    public void recibirMensaje(InfoRequest mensaje) {

    }

    @Override
    public void recibirMensaje(InfoReply mensaje) {

    }
}
