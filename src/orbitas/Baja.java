package orbitas;

import red.Satelite;

import java.util.List;

public class Baja extends Orbita implements OrbitasMoviles {
    public Baja(int alturaMaxima, int alturaMinima, int largo) {
        super(alturaMaxima, alturaMinima, largo);
    }

    @Override
    public void moverSatelites() {
        List<Satelite> satelites = this.getSatelites();
        for (Satelite satelite : satelites) {
            satelite.mover(this.getLargo());
        }
    }
}
