
package org.example;

/*
aqui esta toda la logica de reproducion de musica

 */

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
lista actual es una instancia de listadobleenlazada que almacena canciones
se inicializa lista actual como una nueva instancia de listadoblenlazada esto asegura que
cuando se cree una instancia de reproductor se inicialize una lista vacia
 */
public class Reproductor {
    private ListaDobleEnlazada listaActual;
    private Nodo cancionActual;
    private AdvancedPlayer player;

    public Reproductor() {
        this.listaActual = new ListaDobleEnlazada();
    }

    // se crea un metodo para agregar una cancion a la lista actual
    public void agregarCancion(Cancion cancion) {
        listaActual.agregarCancion(cancion);
    }

    // se crea un metodo para iniciar una cancion de la lista actual
    public void iniciarReproduccion() {
        if (listaActual.getCabeza() != null) {
            cancionActual = listaActual.getCabeza();
            System.out.println("Reproduciendo: " + cancionActual.cancion.getTitulo());
            reproducirCancion(cancionActual.cancion.getRuta());
        } else {
            System.out.println("La lista de reproducción está vacía.");
        }
    }

    // se crea un metodo para pausar la reproduccion de la cancion actual
    public void pausarReproduccion() {
        if (player != null) {
            player.close();
            System.out.println("Pausando canción");
        }
    }

    // se crea un metodo para detener la reproduccion de la cancion actual
    public void detenerReproduccion() {
        if (player != null) {
            player.close();
            System.out.println("Deteniendo canción");
        }
    }

    // se crea un metodo para reproducir la siguiente cancion en la lista actual
    public void siguienteCancion() {
        if (cancionActual != null && cancionActual.siguiente != null) {
            detenerReproduccion();
            cancionActual = cancionActual.siguiente;
            System.out.println("Reproduciendo: " + cancionActual.cancion.getTitulo());
            reproducirCancion(cancionActual.cancion.getRuta());
        } else {
            System.out.println("No hay más canciones en la lista.");
        }
    }

    // se crea un metodo para reproducir la cancion anterior en la lista actual
    public void cancionAnterior() {
        if (cancionActual != null && cancionActual.anterior != null) {
            detenerReproduccion();
            cancionActual = cancionActual.anterior;
            System.out.println("Reproduciendo: " + cancionActual.cancion.getTitulo());
            reproducirCancion(cancionActual.cancion.getRuta());
        } else {
            System.out.println("No hay canciones anteriores en la lista.");
        }
    }

    // se crea un metodo para reproducir una cancion
    private void reproducirCancion(String ruta) {
        try {
            FileInputStream fis = new FileInputStream(ruta);
            player = new AdvancedPlayer(fis);
            new Thread(() -> {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
}