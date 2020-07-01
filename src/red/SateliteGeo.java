package red;

import exceptions.IdOperadorDuplicadoException;

public abstract class SateliteGeo extends Satelite {

    public SateliteGeo(int id, int altura, int diametroVisible) throws IdOperadorDuplicadoException {
        super(id, 0, altura, diametroVisible);
    }


    public SateliteGeo(int id, int altura, int diametroVisible, int posicion) throws IdOperadorDuplicadoException{
        super(id, 0, altura, diametroVisible, posicion);
    }
}
