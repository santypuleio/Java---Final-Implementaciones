package impl;

import api.ColaTDA;

public class ColaEstatica implements ColaTDA{
    int[] v; //definir el vector como entero
    int contador;
    
    public void inicializarCola() {
        // TODO Auto-generated method stub
        v = new int[100];
        contador = 0;
    }

    public void Acolar(int x) {
        // TODO Auto-generated method stub
        v[contador] = x;
    }

    public void Desacolar() {
        for(int j = 0; j<contador-1; j++){
            v[j] = v[j+1];
        }
            contador--;

        // TODO Auto-generated method stub
    }

    public int Primero() {
        // TODO Auto-generated method stub
        int primero = v[0];
        return(primero);
    }

    @Override
    public boolean ColaVacia() {
        // TODO Auto-generated method stub
        return(v[0] == 0);
    }
}
