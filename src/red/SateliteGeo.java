package red;

public abstract class SateliteGeo extends Satelite {

    public SateliteGeo(int id, int altura, int diametroVisible) {
        super(id, 0, altura, diametroVisible);
    }


    public SateliteGeo(int id, int altura, int diametroVisible, int posicion) {
        super(id, 0, altura, diametroVisible, posicion);
    }
}
