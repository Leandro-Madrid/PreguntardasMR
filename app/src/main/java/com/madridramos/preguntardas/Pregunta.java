package com.madridramos.preguntardas;

public class Pregunta {

    private String pregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String respuestaCorrecta;

    // Constructor para inicializar una pregunta con sus opciones y respuesta correcta
    public Pregunta(String pregunta, String opcion1, String opcion2, String opcion3, String respuestaCorrecta) {
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    // Método para obtener la pregunta
    public String getPregunta() {
        return pregunta;
    }

    // Métodos para obtener las opciones
    public String getOpcion1() {
        return opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    // Método para obtener respuesta correcta
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    // Método para verificar si la respuesta es correcta
    public boolean esRespuestaCorrecta(String respuesta) {
        return respuestaCorrecta.equals(respuesta);
    }
}
