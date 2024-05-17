package impl;
import api.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {
   int[] elementos;
   int[] prioridades;
   int indice;
   public void inicializarCola() {
       indice = 0;
       elementos = new int[100];
       prioridades = new int[100];
   }
   public void acolarPrioridad(int x, int prioridad) {
       // desplaza a derecha los elementos de la cola mientras
       // estos tengan mayor o igual prioridad que la de x
       int j = indice;
       for (; j > 0 && prioridades[j - 1] >= prioridad; j--) {
           elementos[j] = elementos[j - 1];
           prioridades[j] = prioridades[j - 1];
       }
       elementos[j] = x;
       prioridades[j] = prioridad;
       indice++;
   }
   public void desacolar() {
       indice--;
   }
   public int primero() {
       return elementos[indice - 1];
   }
   public boolean colaVacia() {
       return (indice == 0);
   }
   public int prioridad() {
       return prioridades[indice - 1];
   }
}