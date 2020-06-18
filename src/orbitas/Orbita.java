package orbitas;

import red.Operador;
import red.Satelite;

import java.util.ArrayList;
import java.util.List;

public class Orbita {

    private List<Satelite> satelites;
    private final int alturaMinima;
    private final int alturaMaxima;
    private final int largo;
    private static int maximoLargo = 1000000;
    private static int minimoLargo = 0;

    public Orbita(int alturaMaxima, int alturaMinima, int largo) {
        this.satelites = new ArrayList<>();
        if(Orbita.maximoLargo < largo){
            this.largo = Orbita.maximoLargo;
        }else{
            this.largo = largo;
        }
        this.alturaMaxima = alturaMaxima;
        this.alturaMinima = alturaMinima;

    }

    public List<Satelite> getSatelites() {
        return this.satelites;
    }

    public int getAlturaMinima() {
        return this.alturaMinima;
    }

    public int getAlturaMaxima() {
        return this.alturaMaxima;
    }

    public int getLargo(){
        return this.largo;
    }

    public static int getMinimoLargo(){
        return Orbita.minimoLargo;
    }

    public static int getMaximoLargo(){
        return Orbita.maximoLargo;
    }

    public void addSatelite(Satelite satelite){
        this.satelites.add(satelite);
        satelite.setPosicion(this.largo);
    }
}
