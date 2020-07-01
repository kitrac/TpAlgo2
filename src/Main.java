import Tierra.Tierra;

public class Main {


    public static void main(String[] args) {
        int tiempo = 1;

        Tierra tierra = new Tierra();
        for (int i = 0; i < tiempo; i++) {
            tierra.run(i);
        }
    }
}
