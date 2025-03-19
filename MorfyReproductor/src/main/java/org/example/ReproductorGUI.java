package org.example;

/*
manejamos la interfas grafica par auqe el usuario peda interactuar
con el reproducotr de musica
 */
//librerias importante para el buen funcionamineto de la aplicacion

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//instancias para reproducir musica , pausar, detener, siguiente, anterior, agregar y eliminar
public class ReproductorGUI extends JFrame {
    private Reproductor reproductor;
    private JButton playButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JButton nextButton;
    private JButton prevButton;
    private JButton addButton;
    private JButton removeButton;

    public ReproductorGUI() {
        reproductor = new Reproductor();
        initUI();
    }

    //dimenciones de la ventana.
    private void initUI() {
        setTitle("Reproductor de Música");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 4));

        // creamos las accciones para la clase reproductor
        //para botones para reproducir, pausar, detener, siguiente...
        playButton = new JButton("Reproducir");
        pauseButton = new JButton("Pausar");
        stopButton = new JButton("Detener");
        nextButton = new JButton("Siguiente");
        prevButton = new JButton("Anterior");
        addButton = new JButton("Agregar");
        removeButton = new JButton("Eliminar");

        panel.add(playButton);
        panel.add(pauseButton);
        panel.add(stopButton);
        panel.add(nextButton);
        panel.add(prevButton);
        panel.add(addButton);
        panel.add(removeButton);

        add(panel);

        //agrega la acccion  para cada boton ya seaa reproducir ,
        // pausar, detener, siguiente, anterior, agregar y eliminar
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.iniciarReproduccion();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.pausarReproduccion();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.detenerReproduccion();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.siguienteCancion();
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.cancionAnterior();
            }
        });

        //agrega una cancion ala lista de reproduccion
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    Cancion cancion = new Cancion(selectedFile.getName(), selectedFile.getAbsolutePath());
                    reproductor.agregarCancion(cancion);
                }
            }
        });

        //eliminar una cancion
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    //inicia la aplicacion y muestra la ventana de la interfaz
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ReproductorGUI ex = new ReproductorGUI();
            ex.setVisible(true);
        });
    }
}

