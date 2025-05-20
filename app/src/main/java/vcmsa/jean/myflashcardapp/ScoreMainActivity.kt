package vcmsa.jean.myflashcardapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log as log

class ScoreMainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score_screen)

        //variables
        val tvScoreAndFeedback = findViewById<TextView>(R.id.tvScoreAndFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)

        //get the score from the intent and if not found then set it to 0
        val score = intent.getIntExtra("score", 0)
        //get the total number of questions from the intent and if not found then set it to 0
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)

        //gives feedback based on the score
        val feedbackMessage = when (score) {
            0 -> "Hah."
            1 -> "That is truly sad."
            2 -> "Needs a little work."
            3 -> "Good job I guess!"
            4 -> "Great work!"
            5 -> "Your the champ!"
            //though it shouldn't be possible to get here but just in case
            else -> "Invalid score."
        }

        //display the score and feedback
        tvScoreAndFeedback.text = "Final Score: $score out of $totalQuestions\nFeedback: $feedbackMessage"

        //logging for tracing and debugging in detail
        log.v("Score", "Final Score: $score out of $totalQuestions")

        //button is clicked
        btnReview.setOnClickListener {
            //when the button is clicked it will go to the next screen
            val intent = Intent(this, ReviewMainActivity::class.java)
            //starting the new activity
            startActivity(intent)

            //logging the button click for debugging
            log.d("Button", "Clicked")
        }

        }


        }


