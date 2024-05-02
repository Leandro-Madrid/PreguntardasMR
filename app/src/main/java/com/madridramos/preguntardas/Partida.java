package com.madridramos.preguntardas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partida {

    private List<Pregunta> preguntas;
    private int preguntaActualIndex;

    // Constructor
    public Partida() {
        // Inicializa y mezcla las preguntas
        preguntas = obtenerPreguntas();
        Collections.shuffle(preguntas);
        preguntaActualIndex = -1; // Índice de pregunta actual
    }

    // Método para obtener la siguiente pregunta
    public Pregunta obtenerPregunta() {
        preguntaActualIndex++;
        return preguntas.get(preguntaActualIndex);
    }

    // Método para verificar respuesta correcta
    public boolean verificarRespuesta(String respuesta) {
        Pregunta preguntaActual = preguntas.get(preguntaActualIndex);
        return preguntaActual.esRespuestaCorrecta(respuesta);
    }

    // Método para obtener preguntas
    private List<Pregunta> obtenerPreguntas() {
        List<Pregunta> preguntas = new ArrayList<>();

        // Add preguntas
        preguntas.add(new Pregunta("¿Este trabajo alcanza para aprobar el parcial?", "Si", "No", "Paraaaaaa", "Si"));
        preguntas.add(new Pregunta("¿Claramente este trabajo está aprobado?", "Si", "No", "Esta opción es incorrecta", "Si"));
        preguntas.add(new Pregunta("¿Es un buen proyecto de juego el Preguntardas?", "Si", "No", "!Si", "Si"));

        return preguntas;
    }
}


