package vcmsa.ci.practicumexam

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore.Audio.Artists
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedView : AppCompatActivity() {

   var Listofsongs: Button? = null
   var Calculate: Button? = null
   var ReturnB: Button? = null
   var list: TextView? = null
   var Calculations_: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)

      Listofsongs = findViewById<View>(R.id.ListofSongs) as Button
      Calculate = findViewById<View>(R.id.Calculate_avr) as Button
      ReturnB = findViewById<View>(R.id.ReturnButton) as Button
      list = findViewById<View>(R.id.Output1) as TextView
      Calculations_= findViewById<View>(R.id.Output2) as TextView

        Listofsongs!!.setOnClickListener {
         val textView: TextView=findViewById(R.id.Output1)
            textView.text=""
            for (i in
            Songs.indices){
                textView = "${textView.text}\n${Songs[i]} by ${Artists[i]} - Rating: ${Rating[i]} - Comments: ${Comments[i]}"
            }


            }




      Calculate!!.setOnClickListener {
          val textView: TextView=findViewById(R.id.Calculate_avr)
          textView.text="Rating: ${Calculate_avr()}"
      }






        ReturnB!!.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()













        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

    private fun Calculate_avr(): String {

}


