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

        Satelite satelite1 = new Satelite(1, 50, 15000, 100);


        this.orbitaMedia.addSatelite(satelite1);

        Estacion estacion = new Estacion(3, largoTierra);

        estacion.addEdge(satelite1);

        this.redSatelital.addEstructura(estacion);
        this.redSatelital.addEstructura(satelite1);

        //   estacion.enviarMensaje(this.redSatelital, new Mensaje(1, estacion, estacion1));
    }


    public void run() {
        this.orbitaBaja.moverSatelites();
        this.orbitaMedia.moverSatelites();

        List<Estacion> estaciones = this.redSatelital.getEstaciones();

        System.out.println(this.redSatelital);

    }

}
