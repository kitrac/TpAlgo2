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
            System.out.println("Consola vacía");
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
        System.out.println("Mensajes entrada:\n");
        for (Mensaje mensaje : this.entrada) {
            System.out.println(mensaje);
        }
        System.out.println("Mensajes salida:\n");
        for (Mensaje mensaje : salida) {
            System.out.println(mensaje);
        }
    }

    public void verMsjEntrada() {
        System.out.println("Mensajes entrada:\n");
        for (Mensaje mensaje : this.entrada) {
            System.out.println(mensaje);
        }
    }

    public void verMsjSalida() {
        System.out.println("Mensajes salida:\n");
        for (Mensaje mensaje : salida) {
            System.out.println(mensaje);
        }
    }
}
