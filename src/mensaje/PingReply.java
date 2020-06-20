package mensaje;

import red.Operador;

import java.util.List;

public class PingReply extends Mensaje {
    private int latencia;

    public PingReply(String id, Operador origen, Operador destino, contenido.PingReply contenido, int latencia) {
        super(id + "Reply", origen, destino, contenido);
        this.latencia = latencia;
    }

    @Override
    public void enviar() {
        Operador origen = this.getOrigen();

        List<Operador> listaVecinos = origen.obtenerVecinos();

        for (Operador operador:listaVecinos) {
            operador.recibirMensaje(this);
        }
    }
}
