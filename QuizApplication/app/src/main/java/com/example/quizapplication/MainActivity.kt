package com.example.quizapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val QUESTION_INDEX_KEY = "QUESTION_INDEX_KEY"

    private lateinit var txtQuestion : TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("QUIZAPP_LIFECYCLE", "OnCreate()...")

        setContentView(R.layout.activity_main)

        //if (savedInstanceState != null) {
        //    currentQuestionIndex = savedInstanceState.getInt(QUESTION_INDEX_KEY)
        //}

        val gameModel: GameModel by viewModels()

        txtQuestion = findViewById(R.id.question_text)
        btnTrue = findViewById(R.id.true_button)
        btnFalse = findViewById(R.id.false_button)
        btnNext = findViewById(R.id.next_button)

        txtQuestion.text = gameModel.currentQuestionText;

        btnTrue.setOnClickListener { v ->
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        }

        btnFalse.setOnClickListener { v ->
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }

        btnNext.setOnClickListener { v ->
            gameModel.nextQuestion()
            txtQuestion.text = gameModel.currentQuestionText
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

        //outState.putInt(QUESTION_INDEX_KEY, currentQuestionIndex)
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
