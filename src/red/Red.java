package red;

import java.util.ArrayList;
import java.util.List;

public class Red {

    private List<Estructura> estructuras;

    public Red() {
        estructuras = new ArrayList<>();
    }

    public void addEstructura(Estructura estructura) {
        estructuras.add(estructura);
    }

    public String toString() {
        return "" + estructuras;
    }
}
