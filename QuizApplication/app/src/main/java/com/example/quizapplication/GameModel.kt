package com.example.quizapplication

import androidx.lifecycle.ViewModel

class GameModel : ViewModel() {
    private val questions = mutableListOf<Question>()
    private var currentQuestionIndex = 0

    init {
        questions.add(Question("¿La luna es de queso?", true))
        questions.add(Question("¿Existe Santa-Claus?", false))
        questions.add(Question("¿El hombre llegó a la luna?", false))
        questions.add(Question("¿La tierra es plana?", true))
        questions.add(Question("¿Es Kotlin mejor que Java?", true))
        questions.add(Question("¿El cielo realmente es azul?", false))
    }

    val currentQuestionText: String
        get() = questions[currentQuestionIndex].text

    val currentQuestionAnswer: Boolean
        get() = questions[currentQuestionIndex].answer

    fun nextQuestion() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
    }
}
