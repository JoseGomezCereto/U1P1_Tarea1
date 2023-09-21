package com.example.u1p1_tarea1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.u1p1_tarea1.databinding.ActivityMainBinding; // Agregamos el import para el AMB

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding; // En lugar de un montón de componentes, declaramos UN único binding.
    private int clickCount = 0; //Declaramos el counter para ir sumando los "clics"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializamos el enlace de vista, según la docu de la cosa ésta, es NECESARIO hacerle el "inflate" éste.
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //También según la docu es NECESARIO usar el .getRoot() para obtener la "primera" vista, la inicial, la que está más arriba
        View view = binding.getRoot();
        //Después de eso, la seteamos como vista de contenido.
        setContentView(view);

        // Añadimos al binding la ToolBar
        setSupportActionBar(binding.toolbar);

        // Añadimos el texto por defecto usando el binding y llamando al textview.
        binding.textView.setText(getString(R.string.contador_default));

        // Configuramos el Listener, usando el binding y llamando al botón.
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Incrementamos el contador cada click.
                clickCount++;

                // Actualizamos el texto del contador, esta vez con 2 parámetros, el contador (texto) y el clickcount (contador)
                binding.textView.setText(getString(R.string.contador, clickCount));
            }
        });
    }
}

/*Explicación del View Binding por ChatGPT 3.5

Propósito de View Binding:
View Binding es una característica de Android que facilita el acceso a las vistas (como TextViews, Buttons, EditTexts, etc.)
que se definen en tus archivos XML de diseño (layouts). Su propósito principal es eliminar la necesidad de buscar manualmente vistas por
su ID (mediante findViewById) y hacer que la interacción con las vistas sea más segura y eficiente.

Cómo funciona:

Generación automática de clases: Cuando habilitas View Binding en tu proyecto, Android Studio genera automáticamente una clase de enlace
de vista para cada archivo XML de diseño en tu proyecto. Estas clases se crean en tiempo de compilación y tienen el mismo nombre que el
archivo XML con "Binding" agregado al final. Por ejemplo, si tienes un archivo XML llamado activity_main.xml, se generará una clase llamada
 ActivityMainBinding.

Acceso a las vistas: En lugar de buscar vistas por su ID como lo harías con findViewById, puedes acceder a las vistas directamente a través
 de la instancia de la clase de enlace de vista. Por ejemplo, si tienes un TextView con el ID textView en tu diseño, puedes acceder a él
 usando binding.textView.

Seguridad de tipo: View Binding utiliza la inferencia de tipo, lo que significa que el compilador verifica automáticamente que estás
accediendo a las vistas correctas con los tipos de datos correctos. Esto evita errores en tiempo de ejecución que podrían ocurrir si
cometes un error tipográfico al buscar vistas por su ID.

Elimina findViewById: Al utilizar View Binding, ya no necesitas llamar a findViewById, lo que hace que tu código sea más limpio y legible,
 ya que elimina una gran cantidad de código redundante.

Mejora el rendimiento: View Binding puede mejorar el rendimiento en comparación con findViewById, ya que las referencias a las vistas se
almacenan de manera eficiente en la clase de enlace de vista y se crean una sola vez durante la inicialización de la actividad.

En resumen, View Binding es una herramienta que simplifica y mejora la forma en que interactúas con las vistas en tu código. Reduce la
 posibilidad de errores, hace que tu código sea más legible y mejora el rendimiento al eliminar la necesidad de buscar manualmente las
 vistas por su ID.*/