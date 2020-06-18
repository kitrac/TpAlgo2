package red;

import mensaje.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class Red {

    private List<Operador> estructuras;

    public Red() {
        estructuras = new ArrayList<>();
    }

    public void addEstructura(Operador estructura) {
        estructuras.add(estructura);
    }

        public String toString() {
            return "" + estructuras;
    }
}
