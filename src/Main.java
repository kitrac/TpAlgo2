import red.Red;
import red.Satelite;

public class Main {

    public static void main(String[] args) {

        Satelite satelite = new Satelite(1);
        Satelite satelite2 = new Satelite(2);
        Satelite satelite3 = new Satelite(3);
        Satelite satelite4 = new Satelite(4);

        satelite4.addEdge(satelite2,100);
        satelite4.addEdge(satelite3,200);

        satelite2.addEdge(satelite,50);

        satelite3.addEdge(satelite2,1000);

        Red grafo = new Red();

        grafo.addEstructura(satelite);
        grafo.addEstructura(satelite2);
        grafo.addEstructura(satelite3);
        grafo.addEstructura(satelite4);

        System.out.println(grafo);
    }
}
