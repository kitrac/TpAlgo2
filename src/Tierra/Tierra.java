package Tierra;

import mensaje.InfoRequest;
import mensaje.Mensaje;
import mensaje.PingRequest;
import orbitas.Baja;
import orbitas.GeoSincrona;
import orbitas.Media;
import orbitas.Orbita;
import red.*;

import java.util.List;

public class Tierra {

    private Red redSatelital;
    private GeoSincrona orbitaGeo;
    private Media orbitaMedia;
    private Baja orbitaBaja;

    private static int largoTierra = Orbita.getMaximoLargo();

    public Tierra() {


        this.redSatelital = new Red();

        this.orbitaGeo = new GeoSincrona(360000, 36000, Orbita.getMaximoLargo());
        this.orbitaMedia = new Media(20000, 10000, Orbita.getMaximoLargo());
        this.orbitaBaja = new Baja(2000, 1500, Orbita.getMaximoLargo());

        Comunicacion satelite1 = new Comunicacion(1, 36000, 10000);
        Comunicacion satelite2 = new Comunicacion(2, 36000, 10000);
        Comunicacion sateliteGeo = new Comunicacion(4, 36000, 10000);
        Meteorologico satelite7 = new Meteorologico(7,300,11000,300);


        this.orbitaGeo.addSatelite(satelite1);
        this.orbitaGeo.addSatelite(satelite2);
        this.orbitaGeo.addSatelite(sateliteGeo);

        this.orbitaMedia.addSatelite(satelite7);

        satelite1.addEdge(sateliteGeo);
        sateliteGeo.addEdge(satelite2);
        satelite1.addEdge(satelite7);

        Estacion estacion = new Estacion(3, largoTierra);
        Estacion estacion1 = new Estacion(5, largoTierra);

        this.redSatelital.addEstructura(estacion);
        this.redSatelital.addEstructura(estacion1);
        this.redSatelital.addEstructura(satelite1);
        this.redSatelital.addEstructura(satelite2);
        this.redSatelital.addEstructura(sateliteGeo);
        this.redSatelital.addEstructura(satelite7);

        for (Satelite satelite : this.redSatelital.getSatelites()) {
            satelite.actualizarEstadoEdges();
            satelite.actualizarDistanciaEdge();
        }

    }


    public void run() {
        this.orbitaBaja.moverSatelites();
        this.orbitaMedia.moverSatelites();

        List<Estacion> estaciones = this.redSatelital.getEstaciones();
        List<Satelite> satelites = this.redSatelital.getSatelites();

        satelites.get(0).enviarMensaje(new InfoRequest("Hola", satelites.get(0), satelites.get(1)));

      //  System.out.println(redSatelital);
    }

}
