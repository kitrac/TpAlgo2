package mensaje;

import red.Operador;

public class InfoRequest extends Mensaje {
    public InfoRequest(String id, Operador origen, Operador destino) {
        super(id, origen, destino);
    }

    @Override
    public void enviar() {

    }

    @Override
    public void reenviarMensaje() {

    }
}
