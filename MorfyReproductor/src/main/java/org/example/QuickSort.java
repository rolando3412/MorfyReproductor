

package org.example;

import java.util.List;
/*
aqui ordenamos la lista de objetos cancion donde se basa en los
titulos utilizando el alg. quicksort
ordena la lista de canciones
particiona la lista

 */
public class QuickSort {
    public static void sort(List<Cancion> canciones) {
        quickSort(canciones, 0, canciones.size() - 1);
    }
/*
implementamos el alg de ordenamiento para ordenar la lista de canciones
 */
    private static void quickSort(List<Cancion> canciones, int low, int high) {
        if (low < high) {
            int pi = partition(canciones, low, high);
            quickSort(canciones, low, pi - 1);
            quickSort(canciones, pi + 1, high);
        }
    }
/*
funcion de particion del alg reorganisamos los elementos de la lista de
tal manera que los elementos del pivote menores se coloquen antes que el y los
mayores despues de el
 */
    private static int partition(List<Cancion> canciones, int low, int high) {
        Cancion pivot = canciones.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (canciones.get(j).getTitulo().compareTo(pivot.getTitulo()) < 0) {
                i++;
                Cancion temp = canciones.get(i);
                canciones.set(i, canciones.get(j));
                canciones.set(j, temp);
            }
        }
        /*
        esta aprte es encargada de del intercambio de elementos de la lista
        y nos devuelve el indice del pivote despues de la particion en el alg de quickSort
         */
        Cancion temp = canciones.get(i + 1);
        canciones.set(i + 1, canciones.get(high));
        canciones.set(high, temp);
        return i + 1;
    }
}

