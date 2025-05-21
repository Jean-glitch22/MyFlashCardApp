package vcmsa.jean.myflashcardapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java
import android.util.Log as log

class FlashcardQuestionsMainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flashcard_question_screen)

        //variables
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val tvScoreCounter = findViewById<TextView>(R.id.tvScoreCounter)
        val tvQuestions = findViewById<TextView>(R.id.tvQuestions)

        //used a youtube video as a reference to help with the code
        //the questions are from chatgpt " 5 funny history trivia questions"
        //https://www.youtube.com/watch?v=K13fR2RHTak
        //an array of questions that will be displayed
        val questions = arrayOf(
            "1. The Great Emu War ended with the Emus outmaneuvering the Australian military.",
            "2. Napoleon was famously allergic to horses.",
            "3. Roman senators used a communal sponge on a stick for wiping in public toilets.",
            "4. George Washington invented the microwave oven.",
            "5. Ancient Egyptians used honey in the embalming process."
        )
        //end of referenced code

        //boolean array of answers to the questions
        val answers = booleanArrayOf(true, false, true, false, true)

        //used a youtube video as a reference to help with the code
        //the answers are from chatgpt " 5 funny history trivia questions"
        //https://www.youtube.com/watch?v=K13fR2RHTak
        //an array of correct messages that will be displayed
        val correctMessages = arrayOf(
            "Correct! The Emus won the war proving that birds beat bullets.",
            "Correct! Napoleon may have been short, but he wasn't horseless. Dude practically lived in the saddle.",
            "Correct! Ancient Rome: where hygiene met horror. One sponge. Many butts.",
            "Correct! Washington could chop wood, not heat Hot Pockets.",
            "Correct! Egyptians really did preserve bodies with honey — like ancient, slightly cursed gummy bears."
        )
        //end of referenced code

        //used a youtube video as a reference to help with the code
        //https://www.youtube.com/watch?v=K13fR2RHTak
        //an array of incorrect messages that will be displayed
        val incorrectMessages = arrayOf(
            "Incorrect. The Emus literally ran circles around the soldiers.",
            "Incorrect. If he had been, half his wars would’ve been fought on foot — very un-dramatic.",
            "Incorrect. They did share a stick-sponge. So yeah… don’t romanticize the past too hard.",
            "Incorrect. George had many talents. Microwaving wasn’t one. He preferred fire and powdered wigs.",
            "Incorrect. Honey was totally in the mix. Tasty, antiseptic, and disturbingly effective on corpses."
        )
        //end of referenced code

        //this keeps track of the current question index
        var currentIndex = 0
        //this keeps track of the score
        var score = 0
        //this keeps track of whether the question has been answered
        var answered = false

        //asked chatgpt "how to update to the next question in kotlin" (40% originality)
        //updates the question
        fun updateQuestion() {
            //updates to next question
            tvQuestions.text = questions[currentIndex]
            //resets the answer flag to false for the next question
            answered = false
        }
        //end of referenced code

        //sets the first question when the activity is created
        tvQuestions.text = questions[currentIndex]
        //sets the score counter to 0 when the activity is created
        tvScoreCounter.text = "Score: $score"

        //used a mixture of a youtube video and my own code as a reference to help with the code
        //https://www.youtube.com/watch?v=K13fR2RHTak
        //button is clicked
        btnTrue.setOnClickListener {
            //checks if the question has been answered
            if (!answered) {
                //checks if the answer is correct and increments the score and displays the correct message
                if (answers[currentIndex]) {
                    score++
                    tvQuestions.text = correctMessages[currentIndex]
                } else {
                    //displays the incorrect message if the answer is incorrect
                    tvQuestions.text = incorrectMessages[currentIndex]
                }
                //updates the score counter
                tvScoreCounter.text = "Score: $score"
                //marks the question as answered
                answered = true

                //logging for debugging
                log.i("Button", "Clicked")
            }
        }
        //end of referenced code

        //used a mixture of a youtube video and my own code as a reference to help with the code
        //https://www.youtube.com/watch?v=K13fR2RHTak
        //button is clicked
        btnFalse.setOnClickListener {
            //checks if the question has been answered
            if (!answered) {
                //checks if the answer is correct and increments the score and displays the correct message
                if (!answers[currentIndex]) {
                    score++
                    tvQuestions.text = correctMessages[currentIndex]
                } else {
                    //displays the incorrect message if the answer is incorrect
                    tvQuestions.text = incorrectMessages[currentIndex]
                }
                //updates the score counter
                tvScoreCounter.text = "Score: $score"
                //marks the question as answered
                answered = true

                //logging for debugging
                log.i("Button", "Clicked")
            }
        }
        //end of referenced code

        //used a mixture of a youtube video and my own code as a reference to help with the code
        //https://www.youtube.com/watch?v=K13fR2RHTak
        //button is clicked
        btnNext.setOnClickListener {
            //checks if the question has been answered
            if (!answered) {
                //stores the current question
                val currentQuestion = questions[currentIndex]
                //asks the user to answer the question if they press next before answering
                tvQuestions.text = "Answer First."

                //delay for 2 seconds before updating the question
                Handler(Looper.getMainLooper()).postDelayed({
                    //shows the current question again after 2 seconds
                    tvQuestions.text = currentQuestion
                }, 2000) //delay of 2000 milliseconds = 2 seconds

                //if not answered then it exits the click listener early
                return@setOnClickListener
            }
            //end of referenced code

            //used a mixture of a youtube video and chatgpt as a reference to help with the code "how to get score to appear on next activity using kotlin code"
            //https://www.youtube.com/watch?v=K13fR2RHTak
            //checks if there are more questions and if so it goes to the next question
            if (currentIndex < questions.size - 1) {
                //increments the question index
                currentIndex++
                //updates the question
                updateQuestion()
            } else {
                //if there are no more questions then it goes to the score screen
                val intent = Intent(this, ScoreMainActivity::class.java)
                //passes over the score to the score screen
                intent.putExtra("score", score)
                //passes over the total number of questions to the score screen
                intent.putExtra("totalQuestions", questions.size)
                //starts the score screen
                startActivity(intent)
                //end of referenced code

                //logging transition to score screen
                log.wtf("Button", "Clicked")
            }
        }
    }
}






