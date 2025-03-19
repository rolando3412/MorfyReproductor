
package org.example;

/*
en esta clsse se encapsula los detalles de las canciones
como el titulo y la ruta de la cancion  alamcena la cncion y
probebe los detalles de las canciones
 */
public class Cancion {
    private String titulo;
    private String ruta;

    public Cancion(String titulo, String ruta) {
        this.titulo = titulo;
        this.ruta = ruta;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getRuta() {
        return ruta;
    }

}