package exceptions;

public class MensajeRepetidoException extends RedSatelitalException {
    public MensajeRepetidoException(String msg) {
        super(msg);
    }

    public MensajeRepetidoException() {
        super();
    }
}
