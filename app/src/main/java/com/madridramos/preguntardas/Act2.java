package com.madridramos.preguntardas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Act2 extends AppCompatActivity {

    private TextView saludo;
    private TextView preguntaText;
    private RadioGroup opcionesGroup;
    private RadioButton opcion1;
    private RadioButton opcion2;
    private RadioButton opcion3;
    private String nombre;
    private Partida partida;
    private Pregunta preguntaActual;
    private int puntaje = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        saludo = findViewById(R.id.saludo);
        preguntaText = findViewById(R.id.pregunta);
        opcionesGroup = findViewById(R.id.opcionesGroup);
        opcion1 = findViewById(R.id.opcion1);
        opcion2 = findViewById(R.id.opcion2);
        opcion3 = findViewById(R.id.opcion3);

        // Obtiene el nombre del jugador pasado desde la actividad anterior
        nombre = getIntent().getStringExtra("n");
        // Muestra un saludo personalizado
        saludo.setText("Hola " + nombre + "!");

        // Inicializa una nueva partida
        partida = new Partida();
        // Muestra la primera pregunta
        mostrarPregunta();
    }

    // Muestra la siguiente pregunta en la actividad
    private void mostrarPregunta() {
        preguntaActual = partida.obtenerPregunta();
        preguntaText.setText(preguntaActual.getPregunta());
        opcion1.setText(preguntaActual.getOpcion1());
        opcion2.setText(preguntaActual.getOpcion2());
        opcion3.setText(preguntaActual.getOpcion3());

        // Borra la selección previa de opciones
        opcionesGroup.clearCheck();
    }

    // Maneja la respuesta seleccionada por el jugador
    public void responder(View v) {
        // Obtiene la opción del jugador
        RadioButton seleccionado = findViewById(opcionesGroup.getCheckedRadioButtonId());

        if (seleccionado != null) {
            // Verifica si la respuesta es correcta
            boolean respuestaCorrecta = partida.verificarRespuesta(seleccionado.getText().toString());
            // Incrementa el puntaje si la respuesta es correcta
            if (respuestaCorrecta) {
                puntaje++;
            }

            // Envía información  a la siguiente actividad
            Intent intent = new Intent(Act2.this, Act3.class);
            intent.putExtra("puntaje", puntaje);
            intent.putExtra("nombre", nombre);
            intent.putExtra("respuesta_correcta", respuestaCorrecta);
            startActivity(intent);
        } else {
            // Mensaje de advertencia si no se seleccionó opción
            Toast.makeText(this, "Por favor, seleccione una opción", Toast.LENGTH_SHORT).show();
        }
    }
}



