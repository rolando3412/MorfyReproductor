package org.example;

/*
una lista doblemente emlazada cada nodo contiene  una
istancia de la clase cancion y las referenciasa al nodo anterior y siguiente de la lista*/

public class Nodo {

    Cancion cancion;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(Cancion cancion) {
        this.cancion = cancion;
        this.anterior = null;
        this.siguiente = null;
    }

    public Cancion getCancion() {
        return cancion;
    }
}
