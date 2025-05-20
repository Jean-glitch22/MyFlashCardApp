package vcmsa.jean.myflashcardapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreMainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score_screen)

        val tvScoreAndFeedback = findViewById<TextView>(R.id.tvScoreAndFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)

        val score = intent.getIntExtra("score", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)

        val feedbackMessage = when (score) {
            0 -> "Hah."
            1 -> "That is truly sad."
            2 -> "Needs a little work."
            3 -> "Good job I guess!"
            4 -> "Great work!"
            5 -> "Your the champ!"
            else -> "Invalid score."
        }

        // Set the score and feedback message to the TextView
        tvScoreAndFeedback.text = "Final Score: $score out of $totalQuestions\nFeedback: $feedbackMessage"

        btnReview.setOnClickListener {
            val intent = Intent(this, ReviewMainActivity::class.java)
            startActivity(intent)
        }

        }


        }


