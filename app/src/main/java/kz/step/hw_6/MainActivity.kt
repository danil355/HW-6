package kz.step.hw_6

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


@Suppress("IMPLICIT_BOXING_IN_IDENTITY_EQUALS", "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity() {
    var VR_REQUEST=999
    var button: Button? = null
    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()

    }

    private fun initializeViews() {
        button = findViewById(R.id.button_click)
        textView = findViewById(R.id.textview)
    }

    private fun initializeLiseners() {

        button?.setOnClickListener {
            val listenIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            //указываем пакет
            listenIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                    javaClass.getPackage().name)
            listenIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say a word!")
            listenIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            listenIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 10)

            val result: String = listenIntent?.toString()
            val wordChosen = textView?.getText()
            Toast.makeText(this,"You said: "+wordChosen,
                    Toast.LENGTH_SHORT).show();

            startActivityForResult(listenIntent, VR_REQUEST)
        }
    }


}
