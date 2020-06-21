package mensaje;

import contenido.Contenido;
import red.Operador;

public class InfoReply extends Mensaje{
    public InfoReply(String id, Operador origen, Operador destino, Contenido contenido) {
        super(id, origen, destino, contenido);
    }

    @Override
    public void enviar() {

    }

    @Override
    public void reenviarMensaje() {

    }
}
