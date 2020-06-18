import Tierra.Tierra;
import red.Estacion;
import red.Red;
import red.Satelite;

public class Main {


    public static void main(String[] args) {
        int cantidadDias = 1;

        Tierra tierra = new Tierra();
        for (int i = 0; i < cantidadDias; i++) {
            tierra.run(i);
        }
    }
}
