package contenido;

public class PingReply extends Contenido {

    private int latencia;

    public PingReply(int distancia) {
        super(true);
        this.latencia = calculoLatencia(distancia);
    }

    public void sumarLatencia(int distanciaRecorrer) {
        this.latencia = this.latencia + calculoLatencia(distanciaRecorrer);
    }

    private int calculoLatencia(int distancia) {
        return distancia / 300000;
    }
}
