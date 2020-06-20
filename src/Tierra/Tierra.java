package Tierra;

import mensaje.Mensaje;
import orbitas.Baja;
import orbitas.GeoSincrona;
import orbitas.Media;
import orbitas.Orbita;
import red.Estacion;
import red.Red;
import red.Satelite;
import red.SateliteGeo;

import java.util.List;

public class Tierra {

    private Red redSatelital;
    private GeoSincrona orbitaGeo;
    private Media orbitaMedia;
    private Baja orbitaBaja;

    private static int largoTierra = Orbita.getMaximoLargo() - 5000;

    public Tierra() {


        this.redSatelital = new Red();

        this.orbitaGeo = new GeoSincrona(360000, 36000, Orbita.getMaximoLargo());  //orbita mas larga porque es la mas lejana
        this.orbitaMedia = new Media(20000, 10000, Orbita.getMaximoLargo() - 2000); //a estas orbitas le bajo un cacho el tamaño para que tenga sentido
        this.orbitaBaja = new Baja(2000, 1500, Orbita.getMaximoLargo() - 4000); //los numeros se eligieron porque si

        Satelite satelite1 = new Satelite(1, 50, 15000, 1000);
        Satelite satelite2 = new Satelite(2, 150, 10000, 1000);
        SateliteGeo sateliteGeo = new SateliteGeo(4, 36000, 1000);


        this.orbitaMedia.addSatelite(satelite1);
        this.orbitaMedia.addSatelite(satelite2);
        this.orbitaGeo.addSatelite(sateliteGeo);

        satelite2.addEdge(satelite1);
        satelite2.addEdge(sateliteGeo);

        Estacion estacion = new Estacion(3, largoTierra);
        Estacion estacion1 = new Estacion(5, largoTierra);

        estacion.addEdge(satelite1);
        estacion.addEdge(estacion1);

        this.redSatelital.addEstructura(estacion);
        this.redSatelital.addEstructura(estacion1);
        this.redSatelital.addEstructura(satelite1);
        this.redSatelital.addEstructura(satelite2);
        this.redSatelital.addEstructura(sateliteGeo);

        //   estacion.enviarMensaje(this.redSatelital, new Mensaje(1, estacion, estacion1));
    }


    public void run() {
        this.orbitaBaja.moverSatelites();
        this.orbitaMedia.moverSatelites();

        List<Estacion> estaciones = this.redSatelital.getEstaciones();

        System.out.println(this.redSatelital);

    }

}
