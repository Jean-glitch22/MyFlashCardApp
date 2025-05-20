package vcmsa.jean.myflashcardapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class ReviewMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_screen)

        val btnExit = findViewById<Button>(R.id.btnExit)

        btnExit.setOnClickListener {
            finish()
            exitProcess(0)
        }

    }
}