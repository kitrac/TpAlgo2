package red;

public class SateliteGeo extends Satelite {

    public SateliteGeo(int id, int velocidad, int altura, int diametroVisible) {
        super(id, velocidad, altura, diametroVisible);
    }

    @Override
    public void mover(int largoOrbita) {  //no se va a usar nunca en un satelite geo pero lo dejo asi por las dudas que se intente usar
        setPosicion(getPosicion()); //puede hacer nada pero puse eso como para que se entienda que mantiene la posicion
    }
}
