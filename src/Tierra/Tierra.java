package Tierra;

import mensaje.InfoRequest;
import mensaje.PingReply;
import mensaje.PingRequest;
import orbitas.Baja;
import orbitas.GeoSincrona;
import orbitas.Media;
import orbitas.Orbita;
import red.*;

public class Tierra {

    private Red redSatelital;
    private GeoSincrona orbitaGeo;
    private Media orbitaMedia;
    private Baja orbitaBaja;

    private static int largoTierra = Orbita.getMaximoLargo();

    public Tierra() {
        this.redSatelital = new Red();

        this.orbitaGeo = new GeoSincrona(360000, 36000, largoTierra);
        this.orbitaMedia = new Media(20000, 10000, largoTierra);
        this.orbitaBaja = new Baja(2000, 1500, largoTierra);

        Comunicacion C1 = new Comunicacion(1, 36000, 4000, 9000);
        Comunicacion C2 = new Comunicacion(2, 36000, 4000, 5000);
        Comunicacion C3 = new Comunicacion(3, 36000, 4000, 2000);

        Meteorologico M1 = new Meteorologico(4, 324, 1700, 500);
        Meteorologico M3 = new Meteorologico(5, 324, 1700, 500);

        Meteorologico M2 = new Meteorologico(6, 324, 11000, 500);
        Meteorologico M4 = new Meteorologico(7, 101, 11000, 500);


        this.orbitaGeo.addSatelite(C1);
        this.orbitaGeo.addSatelite(C2);
        this.orbitaGeo.addSatelite(C3);

        this.orbitaMedia.addSatelite(M2);
        this.orbitaMedia.addSatelite(M4);

        this.orbitaBaja.addSatelite(M1);
        this.orbitaBaja.addSatelite(M3);

        Estacion E1 = new Estacion(8, 9000, largoTierra);
        Estacion E2 = new Estacion(9, 8700, largoTierra);
        Estacion E3 = new Estacion(10, 4500, largoTierra);
        Estacion E4 = new Estacion(11, 2000, largoTierra);

        E1.addEdge(C1);
        E1.addEdge(M1);
        E1.addEdge(E2);

        C1.addEdge(C2);
        C1.addEdge(E2);

        C2.addEdge(C3);

        E2.addEdge(M2);
        E2.addEdge(M3);
        E2.addEdge(C2);

        E3.addEdge(M3);
        E3.addEdge(C2);
        E3.addEdge(M4);

        M4.addEdge(E4);

        E4.addEdge(C3);


        this.redSatelital.addEstructura(C1);
        this.redSatelital.addEstructura(C2);
        this.redSatelital.addEstructura(C3);
        this.redSatelital.addEstructura(M1);
        this.redSatelital.addEstructura(M2);
        this.redSatelital.addEstructura(M3);
        this.redSatelital.addEstructura(M4);
        this.redSatelital.addEstructura(E1);
        this.redSatelital.addEstructura(E2);
        this.redSatelital.addEstructura(E3);
        this.redSatelital.addEstructura(E4);

        for (Satelite satelite : this.redSatelital.getSatelites()) {
            satelite.actualizarEstadoEdges();
            satelite.actualizarDistanciaEdge();
        }

    }


    public void run(int hora) {
        this.orbitaBaja.moverSatelites();
        this.orbitaMedia.moverSatelites();

        System.out.println("\nHora:" + hora + "\n");
        /* PUNTOS GENERALES */

        //3
        Estacion E1 = (Estacion) this.redSatelital.getOperador(8);
        Comunicacion C1 = (Comunicacion) this.redSatelital.getOperador(1);

        E1.enviarMensaje(new PingRequest("3", E1, C1));

        //4
        Estacion E2 = (Estacion) this.redSatelital.getOperador(9);
        E1.enviarMensaje(new PingRequest("4", E1, E2));

        //5
        Estacion E3 = (Estacion) this.redSatelital.getOperador(10);
        Meteorologico M4 = (Meteorologico) this.redSatelital.getOperador(7);
        E3.enviarMensaje(new PingRequest("5", E3, M4));

        //6
        Meteorologico M2 = (Meteorologico) this.redSatelital.getOperador(5);

        E3.enviarMensaje(new PingRequest("6", E3,M2));

        //7
        Estacion E4 = (Estacion) this.redSatelital.getOperador(11);
        Comunicacion C2 = (Comunicacion) this.redSatelital.getOperador(2);

        E4.enviarMensaje(new PingRequest("7", E4,C2));

        /* PUNTOS DEL EQUIPO */
        //B H

        Meteorologico M1 = (Meteorologico) this.redSatelital.getOperador(4);

        E1.enviarMensaje(new InfoRequest("B", E1, M1));

        //C
        Comunicacion C3 = (Comunicacion) this.redSatelital.getOperador(3);
        E2.enviarMensaje(new InfoRequest("C", E2, C3));

        //D
        E3.enviarMensaje(new InfoRequest("D", E3, C2));

        //E G

        E3.enviarMensaje(new InfoRequest("E", E3, M1));

        //F

        E3.enviarMensaje(new InfoRequest("D", E3, C2));


        //  System.out.println(redSatelital);
    }

}
