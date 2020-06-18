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

    public List<Satelite> getSatelites() {
        List<Satelite> satelites = new ArrayList<>();

        for (Operador operador : estructuras) {
            if (operador instanceof Satelite) {
                satelites.add((Satelite) operador);
            }
        }
        return satelites;
    }

    public List<Estacion> getEstaciones() {
        List<Estacion> estaciones = new ArrayList<>();

        for (Operador operador : estructuras) {
            if (operador instanceof Estacion) {
                estaciones.add((Estacion) operador);
            }
        }
        return estaciones;
    }

    public String toString() {
        return "" + estructuras;
    }
}
