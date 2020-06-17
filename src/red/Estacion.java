package red;

import mensaje.Mensaje;

public class Estacion extends Operador {

    public Estacion(int id){
        super(id);
    }

    public Mensaje generarMensaje(int id, Operador origen, Operador destino, String contenido){
        Mensaje mensaje = new Mensaje(id, this, destino , contenido);
        return mensaje;
    }
}
