package org.example;

import javax.swing.*;
/*
el metodo principal sirve como punto de entrada ala aplicacion, para la cadena
de eventos y mostrar la GUI
 */

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReproductorGUI ex = new ReproductorGUI();
            ex.setVisible(true);

            ListaDobleEnlazada lista = new ListaDobleEnlazada();
            lista.agregarCancion(new Cancion("Cancion 1", "ruta1.mp3"));
            lista.agregarCancion(new Cancion("Cancion 2", "ruta2.mp3"));
/*
se obtiene  el ultimo nodo de la lista doble enlazada y verificamos si no esta vacia y si
no lo esta se imprime los detalles de la ultima cancion
 */
            Nodo ultimoNodo = lista.getCola();
            if (ultimoNodo != null) {
                Cancion ultimaCancion = ultimoNodo.getCancion();
                System.out.println("Última canción: " + ultimaCancion.getTitulo() + " - " + ultimaCancion.getRuta());
            } else {
                System.out.println("La lista está vacía.");
            }
        });
    }
}


