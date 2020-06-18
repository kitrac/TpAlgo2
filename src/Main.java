import Tierra.Tierra;

public class Main {


    public static void main(String[] args) {
        int cantidadDias = 1;

        Tierra tierra = new Tierra();
        for (int i = 0; i < cantidadDias; i++) {
            tierra.run(i);
        }
    }
}
