package mensaje;

import red.Operador;

import java.util.List;

public class PingRequest extends Mensaje{

    public PingRequest(String id, Operador origen, Operador destino) {
        super(id + "Request", origen, destino);
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
