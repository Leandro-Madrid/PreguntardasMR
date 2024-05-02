package com.madridramos.preguntardas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;

public class Act3 extends AppCompatActivity {

    private TextView textViewPuntaje;
    private TextView textViewNombre;
    private TextView textViewRespuesta;
    private ImageView imageViewAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);

        // Inicializa los elementos de la interfaz de usuario
        textViewPuntaje = findViewById(R.id.textViewPuntaje);
        textViewNombre = findViewById(R.id.nombre);
        textViewRespuesta = findViewById(R.id.textViewRespuesta);
        imageViewAvatar = findViewById(R.id.imageViewAvatar);

        // Obtiene los datos pasados de la actividad anterior
        int puntaje = getIntent().getIntExtra("puntaje", 0);
        String nombre = getIntent().getStringExtra("nombre");
        boolean respuestaCorrecta = getIntent().getBooleanExtra("respuesta_correcta", false);

        // Muestra los datos
        textViewNombre.setText("Nombre: " + nombre);
        textViewPuntaje.setText("Puntaje final: " + puntaje);
        textViewRespuesta.setText("Respuesta: " + (respuestaCorrecta ? "Correcta" : "Incorrecta"));

        // Muestra el avatar correspondiente
        if (respuestaCorrecta) {
            imageViewAvatar.setImageResource(R.drawable.ok);
        } else {
            imageViewAvatar.setImageResource(R.drawable.nook);
        }

        // Botón "Volver a Jugar"
        Button volverAJugar = findViewById(R.id.button_volver);
        volverAJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia la actividad principal y finaliza la actual
                Intent intent = new Intent(Act3.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Botón "Salir"
        Button salir = findViewById(R.id.button_salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra y sale de la aplicación
                finishAffinity();
            }
        });
    }
}





