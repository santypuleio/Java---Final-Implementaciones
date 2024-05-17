package impl;
import api.ListaPromediadaTDA;
import api.Nodo;
import api.ColaPrioridadTDA;

public class ListaPromediadaDinamica implements ListaPromediadaTDA{
    Nodo primero;
    Nodo ultimo;
    int contador;

    public void inicializar() {
        primero = null;
        ultimo = null;
        contador = 0;
        ;
    }

    public void agregar(int x) {
        Nodo aux = new Nodo();
        aux.valor = x;
        if(primero == null){
            primero = aux;
            ultimo = aux;
            contador = contador + 1;
            System.out.println("Estaba vacia y agrego.");
        }
        else{
            if (aux.valor < promedio()) {
                Nodo segundo = primero;
                primero = aux;
                primero.sig = segundo;
                contador = contador + 1;
                System.out.println("Era menor a promedio y agrego.");
            }
            else if(aux.valor > promedio()){
                ultimo.sig = aux;
                ultimo = aux;
                contador = contador + 1;
                System.out.println("Era mayor a promedio y agrego.");
            }
            else if(aux.valor == promedio()){
                System.out.println("No se ingresó el valor porque es igual al promedio.");
            }
        };
    }

    public void eliminar(int x) {
        Nodo salto = primero; 
        while (salto != null) {
            if(salto.valor == x && salto == primero){
                primero = primero.sig;
                System.out.println("era el primero y se elimino");
            }
            else if(salto.valor == x && salto == ultimo){
                Nodo saltoaux = primero;
                Nodo anteultimo = new Nodo();
                //recorrer todos los nodos
                while (saltoaux != null) {
                    if(salto.sig == ultimo){
                        anteultimo = salto;
                    }
                    if(salto == ultimo){
                        ultimo = anteultimo;
                    }
                    saltoaux = saltoaux.sig;                   
                }
                System.out.println("era el ultimo y se elimino");
            }
            else if(salto.valor == x && salto != primero && salto != ultimo){
                Nodo saltoaux = primero;
                while (saltoaux != null) {
                    if (saltoaux.sig == salto) {
                        if (salto.sig.sig == null) {
                            ultimo = salto;
                        }
                        else{
                            salto.sig = salto.sig.sig;
                        }
                    }
                    saltoaux = saltoaux.sig;
                    
                }
                System.out.println("estaba en el medio y se elimino");
            }
            salto = salto.sig;
        }
        contador = contador - 1;
    }

    public int promedio() {
        Nodo salto = primero;
        int sumaTotal = 0;
        int contadorLocal = 0;
        while (salto != null) {
            sumaTotal = sumaTotal + salto.valor;
            salto = salto.sig;
            contadorLocal = contadorLocal + 1;
        }
        if(contadorLocal == 0){
            return 0;
        }
        return(sumaTotal/(contadorLocal));
    }

    public ColaPrioridadTDA menores() {
        int prom = promedio();
        Nodo salto = primero;
        ColaPrioridadTDA valoresMenores = new ColaPrioridadEstatica();
        valoresMenores.inicializarCola();
        while (salto != null) {
            if(salto.valor < prom){
                valoresMenores.acolarPrioridad(salto.valor, salto.valor);
            }
            salto = salto.sig;
        };
        
        //print de prueba
        while (!valoresMenores.colaVacia()) {
            System.out.println(valoresMenores.primero());
            valoresMenores.desacolar();
        }
        return(valoresMenores);
    } // como usas la colaPrioridad, acolarPrioridad tiene costo lineal, y menores también, entonces el costo se hace cuadratico.

    public ColaPrioridadTDA mayores() {
        Nodo saltoAux = primero;
        ColaPrioridadTDA valoresMayores = new ColaPrioridadEstatica();
        valoresMayores.inicializarCola();
        int prom = promedio();

        while (saltoAux != null) {
            if(saltoAux.valor > prom){
                valoresMayores.acolarPrioridad(saltoAux.valor, -saltoAux.valor);
            }
            saltoAux = saltoAux.sig;
        };

        //print de prueba
        while (!valoresMayores.colaVacia()) {
            System.out.println(valoresMayores.primero());
            valoresMayores.desacolar();
        }
        return(valoresMayores);
    }

    public boolean estaVacia() {
        return(contador == 0);
    }
}
