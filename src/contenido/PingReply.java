package contenido;

public class PingReply extends Contenido {

    private double latencia;

    public PingReply(int distancia) {
        super(true);
        this.latencia = calculoLatencia(distancia);
    }

    public void sumarLatencia(double distanciaRecorrer) {
        this.latencia  = this.latencia + calculoLatencia(distanciaRecorrer);
    }

    private double calculoLatencia(double distancia) {
        return distancia / 300000;
    }

    @Override
    public String toString() {
        return "latencia =" + latencia;
    }
}
