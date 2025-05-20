package vcmsa.jean.myflashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log as log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.welcome_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//starting code here

        //variables
        val btnStart = findViewById<Button>(R.id.btnStart)

        //button is clicked
        btnStart.setOnClickListener {
            //when the button is clicked it will go to the next screen
            val intent = Intent(this, FlashcardQuestionsMainActivity::class.java)
            //starting the new activity
            startActivity(intent)

            log.d("Button", "Clicked")

        }

    }
}
