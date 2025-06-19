package vcmsa.ci.practicumexam

import android.content.Intent
import android.media.Rating
import android.os.Bundle
import android.provider.MediaStore.Audio.Artists
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

  var The_song_title: EditText? = null
  var The_artists_name: EditText? = null
  var The_ratings: EditText? = null
  var UseraComments: EditText? = null
  var Addtoplaylist: Button? = null
  var NextB: Button? = null
  var ExitB: Button? = null


    val Questions = arrayOf(
        "The Song Title",
        "The Artist's Name",
        "The Rating",
        "User Comments"
    )

    val Answers = arrayOf(
        arrayOf("Bayazi","Best Part","Be careful","LoVE ME jeje"),
        arrayOf("Cowboii","H.E.R","Cardi B","Tems"),
        arrayOf("8","5","9","7"),
        arrayOf("Amapiano","RNB","HipHop","Afro-Beats")
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

      The_song_title = findViewById<View>(R.id.The_Song_title) as EditText
      The_artists_name = findViewById<View>(R.id.The_Artists_Name) as EditText
      The_ratings = findViewById<View>(R.id.The_Ratng) as EditText
      UseraComments = findViewById<View>(R.id.User_Comments) as EditText
      Addtoplaylist = findViewById<View>(R.id.Add_To_Playlist) as Button
      NextB = findViewById<View>(R.id.NextButton) as Button
      ExitB = findViewById<View>(R.id.ExitButton) as Button


       Addtoplaylist!!.setOnClickListener {
           val Songs= The_song_title!!.text.toString()
           val Artists = The_artists_name!!.text.toString()
           val Ratings = The_ratings!!.text.toString().toInt()
           val Comments = UseraComments!!.text.toString()

           if (Songs.isEmpty()||Artists.isEmpty()||Comments.isEmpty()) {
               Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
               return@setOnClickListener
           }

           val Rating =  Ratings.toInt()or null()
           if (Rating == null || Rating<= 0){
               Toast.makeText(this, "Enter" +
                       "")
           }




           }










    NextB!!.setOnClickListener {
        val Intent = Intent(this, DetailedView::class.java)
        startActivity(intent)
        finish()
    }
    ExitB!!.setOnClickListener {
        finishAffinity()
    }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}