import api.ListaPromediadaTDA;
import impl.ListaPromediadaDinamica;

public class App {
    public static void main(String[] args) throws Exception {
        ListaPromediadaTDA lp= new ListaPromediadaDinamica();
        lp.inicializar();
        lp.agregar(1);
        lp.agregar(2);
        lp.agregar(0);

        lp.eliminar(2);
        lp.eliminar(1);

        System.out.println(lp.promedio());

        lp.mayores();
        lp.menores();
    }
}
