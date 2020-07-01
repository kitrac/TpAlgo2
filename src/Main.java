import tierra.Tierra;
import exceptions.RedSatelitalException;

public class Main {


    public static void main(String[] args) {
        int tiempo = 1;
        try {
            Tierra tierra = new Tierra();
            for (int i = 0; i < tiempo; i++) {
                tierra.run(i);
            }
        } catch (RedSatelitalException e) {
            System.out.println(e);
        }


    }
}
