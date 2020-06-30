package contenido;

public class InfoReply extends Contenido implements Cloneable {

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
    public InfoReply clone() {
        return new InfoReply(this.getReenvio(),this.idSatelite,this.distanciaOrigen);
    }

    @Override
    public String toString() {
        return "InfoReply{" +
                "idSatelite=" + idSatelite +
                ", distanciaOrigen=" + distanciaOrigen +
                '}';
    }
}
