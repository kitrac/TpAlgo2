package contenido;

public class InfoReply extends Contenido {

    private int idSatelite;
    private double distanciaOrigen;

    public InfoReply(boolean reenvio, int idSatelite, double distanciaOrigen) {
        super(reenvio);
        this.idSatelite = idSatelite;
        this.distanciaOrigen = distanciaOrigen;
    }

    public void sumarDistancia(double distanciaRecorrer) {
        this.distanciaOrigen  = this.distanciaOrigen + distanciaRecorrer;
    }

    @Override
    public String toString() {
        return "InfoReply{" +
                "idSatelite=" + idSatelite +
                ", distanciaOrigen=" + distanciaOrigen +
                '}';
    }
}
