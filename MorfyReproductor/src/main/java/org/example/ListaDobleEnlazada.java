
package org.example;

/*
almacena y gestiona una coleccion de objetos de tipo cancion 
se proporcionan los metodos nesesarios para agrgar canciones ala lista y 
acceder alos nodos primero y ultimo
 */
public class ListaDobleEnlazada {
    private Nodo cabeza;
    private Nodo cola;

    public ListaDobleEnlazada() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarCancion(Cancion cancion) {
        Nodo nuevoNodo = new Nodo(cancion);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public Nodo getCola() {
        return cola;
    }


}




