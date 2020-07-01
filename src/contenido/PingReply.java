package contenido;

public class PingReply extends Contenido implements Cloneable{

    private double latencia;

    public PingReply(int distancia) {
        super(true);
        this.latencia = calculoLatencia(distancia);
    }

    public PingReply(double latencia) {
        super(true);
        this.latencia = latencia;
    }

    public void sumarLatencia(double distanciaRecorrer) {
        this.latencia = this.latencia + calculoLatencia(distanciaRecorrer);
    }

    private double calculoLatencia(double distancia) {
        return (distancia / 300000) * 2;
    }

    public double getLatencia() {
        return latencia;
    }

    @Override
    public String toString() {
        return "latencia =" + latencia;
    }
}
