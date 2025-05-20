package vcmsa.jean.myflashcardapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.util.Log as log

class ReviewMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_screen)

        //variable
        val btnExit = findViewById<Button>(R.id.btnExit)

        //button is clicked
        btnExit.setOnClickListener {
            //when the button is clicked it will exit the app
            finishAffinity()

            //logging the exit process
            log.e("Button", "Clicked")
        }

    }
}