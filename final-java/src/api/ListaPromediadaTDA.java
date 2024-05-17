package api;

public interface ListaPromediadaTDA {
    public void inicializar();
    public void agregar(int x);
    public void eliminar(int x);
    public int promedio(); //de la lista
    public ColaPrioridadTDA menores(); //los menores al promedio
    public ColaPrioridadTDA mayores(); //los mayores al promedio
    public boolean estaVacia();
}