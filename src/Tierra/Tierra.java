package Tierra;

import orbitas.Baja;
import orbitas.GeoSincrona;
import orbitas.Media;
import red.Estacion;
import red.Red;
import red.Satelite;

public class Tierra {

    private Red redSatelital;
    private GeoSincrona orbitaGeo;
    private Media orbitaMedia;
    private Baja orbitaBaja;

    public Tierra() {

        this.redSatelital = new Red();

        this.orbitaGeo = new GeoSincrona(360000, 36000, 100000);
        this.orbitaMedia = new Media(20000, 10000, 95000);
        this.orbitaBaja = new Baja(2000, 1500, 60000);

        Satelite satelite3 = new Satelite(3, 100, 15000);
        Satelite satelite4 = new Satelite(4, 100, 1600);

        satelite4.addEdge(satelite3, 200);

        this.orbitaMedia.addSatelite(satelite3);
        this.orbitaBaja.addSatelite(satelite4);

        Estacion estacion = new Estacion(5, 15000, 10000);
        Estacion estacion1 = new Estacion(6, 15000, 10000);

        estacion.addEdge(estacion1, 1000);

        this.redSatelital.addEstructura(satelite3);
        this.redSatelital.addEstructura(satelite4);
        this.redSatelital.addEstructura(estacion);
        this.redSatelital.addEstructura(estacion1);
    }


    public void run() {
        this.orbitaBaja.moverSatelites();
        this.orbitaMedia.moverSatelites();

    }

}
