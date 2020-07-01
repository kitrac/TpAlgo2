package exceptions;

public class OperadorDesconectadoException extends RedSatelitalException {
    public OperadorDesconectadoException(String msg) {
        super(msg);
    }

    public OperadorDesconectadoException() {
        super();
    }
}
