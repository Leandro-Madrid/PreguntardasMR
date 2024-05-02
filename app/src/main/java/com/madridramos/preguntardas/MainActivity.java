package com.madridramos.preguntardas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre; // Entrada de nombre

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre); // Vincula EditTexta entrada de nombre del layout

        Button botonEmpezar = findViewById(R.id.button_empezar); // Toma botón de inicio en el layout
        botonEmpezar.setOnClickListener(new View.OnClickListener() { // Listener para botón
            @Override
            public void onClick(View v) {
                String nombreJugador = nombre.getText().toString(); // Obtiene el nombre
                Intent intent = new Intent(MainActivity.this, Act2.class); // Intent para iniciar Act2
                intent.putExtra("n", nombreJugador); // Pasa el nombre del jugador a  actividad
                startActivity(intent); // Inicia la siguiente actividad
            }
        });
    }
}

