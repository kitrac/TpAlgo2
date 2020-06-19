package Tierra;

import mensaje.Mensaje;
import orbitas.Baja;
import orbitas.GeoSincrona;
import orbitas.Media;
import red.Estacion;
import red.Red;
import red.Satelite;

import java.util.List;

public class Tierra {

    private Red redSatelital;
    private GeoSincrona orbitaGeo;
    private Media orbitaMedia;
    private Baja orbitaBaja;

    private static int largoTierra = 3000;

    public Tierra() {


        this.redSatelital = new Red();

        this.orbitaGeo = new GeoSincrona(360000, 36000, 9000);
        this.orbitaMedia = new Media(20000, 10000, 6000);
        this.orbitaBaja = new Baja(2000, 1500, 4000);

        Satelite satelite3 = new Satelite(1, 50, 15000, 300);
        Satelite satelite4 = new Satelite(4, 50, 1600, 300);

        satelite4.addEdge(satelite3, 200);

        this.orbitaMedia.addSatelite(satelite3);
        this.orbitaBaja.addSatelite(satelite4);

        Estacion estacion = new Estacion(3, largoTierra);
        Estacion estacion1 = new Estacion(6, largoTierra);

        estacion.addEdge(satelite3);
        estacion.addEdge(estacion1, 1000);

        this.redSatelital.addEstructura(satelite3);
        this.redSatelital.addEstructura(satelite4);
        this.redSatelital.addEstructura(estacion);
        this.redSatelital.addEstructura(estacion1);

        estacion.enviarMensaje(this.redSatelital, new Mensaje(1, estacion, estacion1));
    }


    public void run() {
        this.orbitaBaja.moverSatelites();
        this.orbitaMedia.moverSatelites();

        List<Estacion> estaciones = this.redSatelital.getEstaciones();

        System.out.println(this.redSatelital);

    }

}
