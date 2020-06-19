package red;

import orbitas.Orbita;

public class SateliteGeo extends Satelite {

    private int maximoRango;
    private int minimoRango;

    public SateliteGeo(int id, int velocidad, int altura, int maximoRango, int minimoRango) {
        super(id, velocidad, altura);

        if (Orbita.getMinimoLargo() < minimoRango && Orbita.getMaximoLargo() > maximoRango) {
            this.maximoRango = maximoRango;
            this.minimoRango = minimoRango;
        } else {
            //aca iria un error
        }
    }

    private boolean dentroRango(int posicion) {
        return posicion >= minimoRango && posicion <= maximoRango;
    }


}
