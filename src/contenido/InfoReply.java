package contenido;

public class InfoReply extends Contenido {

    private int idSatelite;
    private int distanciaOrigen;

    public InfoReply(boolean reenvio, int idSatelite, int distanciaOrigen) {
        super(reenvio);
        this.idSatelite = idSatelite;
        this.distanciaOrigen = distanciaOrigen;
    }
}
