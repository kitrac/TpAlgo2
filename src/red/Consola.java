package red;

import mensaje.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class Consola {
    private List<Mensaje> entrada;
    private List<Mensaje> salida;

    public Consola() {   //debería correrse una vez con la inicializacion de cada operador
        this.entrada = new ArrayList<>();
        this.salida = new ArrayList<>();
    }

    public void verEstado() {
        if (this.entrada.isEmpty() && this.salida.isEmpty()) {
            System.out.println("\nCONSOLA VACIA");
        } else {
            if (this.entrada.size() > 0) {
                System.out.println("Bandeja de entrada tiene: " + this.entrada.size() + " mensajes");
            } else {
                System.out.println("Bandeja de entrada vacia");
            }

            if (this.salida.size() > 0) {
                System.out.println("Bandeja de salida tiene: " + this.salida.size() + " mensajes");
            } else {
                System.out.println("Bandeja salida vacia");
            }
        }
    }

    public void limpiarConsola() {
        this.entrada.clear();
        this.salida.clear();
    }

    public void addMensajeEntrada(Mensaje mensaje) { //tal vez aquí en vez de estar en operadores
        this.entrada.add(mensaje);
    }

    public void addMensajeSalida(Mensaje mensaje) {
        this.salida.add(mensaje);
    }

    public void verConsola() {
        if (this.entrada.isEmpty() && this.salida.isEmpty()) {
            System.out.println("\nCONSOLA VACIA");
        } else {
            if (this.entrada.size() > 0) {
                System.out.println("\n****Mensajes entrada******\n");
                for (Mensaje mensaje : this.entrada) {
                    System.out.println(mensaje);
                }
            } else {
                System.out.println("Bandeja entrada vacia");
            }
            if (this.salida.size() > 0) {
                System.out.println("\n****Mensajes salida****\n");
                for (Mensaje mensaje : salida) {
                    System.out.println(mensaje);
                }
            } else {
                System.out.println("Bandeja salida vacia");
            }

        }
    }

    public List<Mensaje> getEntrada() {
        return entrada;
    }

    public List<Mensaje> getSalida() {
        return salida;
    }

    public Mensaje getMensajeEntrada(String id) {

        for (Mensaje mensaje : entrada) {
            if (mensaje.getId().equals(id)) {
                return mensaje;
            }
        }
        return null;
    }

    public Mensaje getMensajeSalida(String id) {
        for (Mensaje mensaje : salida) {
            if (mensaje.getId().equals(id)) {
                return mensaje;
            }
        }
        return null;
    }

    public void verMsjEntrada() {
        System.out.println("\n****Mensajes entrada******\n");
        for (Mensaje mensaje : this.entrada) {
            System.out.println(mensaje);
        }
    }

    public void verMsjSalida() {
        System.out.println("\n****Mensajes salida****\n");
        for (Mensaje mensaje : salida) {
            System.out.println(mensaje);
        }
    }
}
