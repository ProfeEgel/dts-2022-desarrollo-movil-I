package com.example.quizapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val QUESTION_INDEX_KEY = "QUESTION_INDEX_KEY"

    private lateinit var txtQuestion : TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button

    private val questions = mutableListOf<Question>()
    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("QUIZAPP_LIFECYCLE", "OnCreate()...")

        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            currentQuestionIndex = savedInstanceState.getInt(QUESTION_INDEX_KEY)
        }

        txtQuestion = findViewById(R.id.question_text)
        btnTrue = findViewById(R.id.true_button)
        btnFalse = findViewById(R.id.false_button)
        btnNext = findViewById(R.id.next_button)

        questions.add(Question("¿La luna es de queso?", true))
        questions.add(Question("¿Existe Santa-Claus?", false))
        questions.add(Question("¿El hombre llegó a la luna?", false))
        questions.add(Question("¿La tierra es plana?", true))
        questions.add(Question("¿Es Kotlin mejor que Java?", true))
        questions.add(Question("¿El cielo realmente es azul?", false))

        txtQuestion.text = questions[currentQuestionIndex].text;

        btnTrue.setOnClickListener { v ->
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        }

        btnFalse.setOnClickListener { v ->
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }

        btnNext.setOnClickListener { v ->
            currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
            txtQuestion.text = questions[currentQuestionIndex].text
        }

        /*
        TAREA #1
        1. Agregar boton PREV (previous) y su funcionalidad
        2. Implementar validación de la respuesta correcta
        3. Indicar de manera visual que una pregunta ya fue respondida (correcta e incorrecta)
        4. No permitir responder una pregunta más de una vez
        5. Indicador de "pregunta actual"/"total de preguntas" en la parte superior de la pantalla
        6. Indicador de "puntuación"
         */
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("QUIZAPP_LIFECYCLE", "OnSaveInstanceState()...")

        outState.putInt(QUESTION_INDEX_KEY, currentQuestionIndex)
    }

    override fun onStart() {
        super.onStart()
        Log.d("QUIZAPP_LIFECYCLE", "OnStart()...")
    }

    override fun onResume() {
        super.onResume()
        Log.d("QUIZAPP_LIFECYCLE", "OnResume()...")
    }

    override fun onPause() {
        super.onPause()
        Log.d("QUIZAPP_LIFECYCLE", "OnPause()...")
    }

    override fun onStop() {
        super.onStop()
        Log.d("QUIZAPP_LIFECYCLE", "OnStop()...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("QUIZAPP_LIFECYCLE", "OnDestroy()...")
    }
}
