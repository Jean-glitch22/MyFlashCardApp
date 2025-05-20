package vcmsa.jean.myflashcardapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java

class FlashcardQuestionsMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flashcard_question_screen)

        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val tvScoreCounter = findViewById<TextView>(R.id.tvScoreCounter)
        val tvQuestions = findViewById<TextView>(R.id.tvQuestions)

        val questions = arrayOf(
            "1. The Great Emu War ended with the emus outmaneuvering the Australian military.",
            "2. Napoleon was famously allergic to horses.",
            "3. Roman senators used a communal sponge on a stick for wiping in public toilets.",
            "4. George Washington invented the microwave oven.",
            "5. Ancient Egyptians used honey in the embalming process."
        )

        val answers = booleanArrayOf(true, false, true, false, true)

        val correctMessages = arrayOf(
            "Correct! The emus won the war proving that birds beat bullets.",
            "Correct! Napoleon may have been short, but he wasn't horseless. Dude practically lived in the saddle.",
            "Correct! Ancient Rome: where hygiene met horror. One sponge. Many butts.",
            "Correct! Washington could chop wood, not heat Hot Pockets.",
            "Correct! Egyptians really did preserve bodies with honey — like ancient, slightly cursed gummy bears."
        )

        val incorrectMessages = arrayOf(
            "Incorrect. The emus literally ran circles around the soldiers.",
            "Incorrect. If he had been, half his wars would’ve been fought on foot — very un-dramatic.",
            "Incorrect. They did share a stick-sponge. So yeah… don’t romanticize the past too hard.",
            "Incorrect. George had many talents. Microwaving wasn’t one. He preferred fire and powdered wigs.",
            "Incorrect. Honey was totally in the mix. Tasty, antiseptic, and disturbingly effective on corpses."
        )

        var currentIndex = 0
        var score = 0
        var answered = false

        fun updateQuestion() {
            tvQuestions.text = questions[currentIndex]
            answered = false
        }

        // Display the first question and initial score
        tvQuestions.text = questions[currentIndex]
        tvScoreCounter.text = "Score: $score"

        btnTrue.setOnClickListener {
            if (!answered) {
                if (answers[currentIndex]) {
                    score++
                    tvQuestions.text = correctMessages[currentIndex]
                } else {
                    tvQuestions.text = incorrectMessages[currentIndex]
                }
                tvScoreCounter.text = "Score: $score"
                answered = true
            }
        }

        btnFalse.setOnClickListener {
            if (!answered) {
                if (!answers[currentIndex]) {
                    score++
                    tvQuestions.text = correctMessages[currentIndex]
                } else {
                    tvQuestions.text = incorrectMessages[currentIndex]
                }
                tvScoreCounter.text = "Score: $score"
                answered = true
            }
        }

        btnNext.setOnClickListener {
            if (!answered) {
                val currentQuestion = questions[currentIndex]
                tvQuestions.text = "Answer First."

                Handler(Looper.getMainLooper()).postDelayed({
                    tvQuestions.text = currentQuestion
                }, 2000) // Delay of 2000 milliseconds = 2 seconds

                return@setOnClickListener
            }
            if (currentIndex < questions.size - 1) {
                currentIndex++
                updateQuestion()
            } else {
                // Go to the score screen
                val intent = Intent(this, ScoreMainActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("totalQuestions", questions.size)
                startActivity(intent)
            }
        }
    }
}






