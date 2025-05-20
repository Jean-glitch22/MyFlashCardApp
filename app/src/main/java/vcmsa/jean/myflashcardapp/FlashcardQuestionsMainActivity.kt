package vcmsa.jean.myflashcardapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlashcardQuestionsMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flashcard_question_screen)
        }//starting code here

    val tvQuestions = findViewById<TextView>(R.id.tvQuestions)
    val tvScoreCounter = findViewById<TextView>(R.id.tvScoreCounter)
    val btnTrue = findViewById<Button>(R.id.btnTrue)
    val btnFalse = findViewById<Button>(R.id.btnFalse)
    val btnNext = findViewById<Button>(R.id.btnNext)



    }


