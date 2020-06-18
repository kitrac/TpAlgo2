package orbitas;

import red.Satelite;

import java.util.List;

public class Media extends Orbita implements OrbitasMoviles {
    public Media(int alturaMaxima, int alturaMinima, int largo) {
        super(alturaMaxima, alturaMinima, largo);
    }

    @Override
    public void moverSatelites() {
        List<Satelite> satelites = this.getSatelites();
        for (Satelite satelite : satelites) {
            satelite.mover();
        }
    }
}
