package mensaje;

public class PingReply implements Contenido {
    private int latencia;

    public void Contenido(int latencia) {
        this.latencia = latencia;
    }
}
