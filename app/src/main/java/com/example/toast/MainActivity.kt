package com.example.toast

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.System.console


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view)
        textView.text = "Jason rocks"

        var counter = 1

        val counterView = findViewById<TextView>(R.id.counter)

        val button = findViewById<Button>(R.id.button);
        button.setOnClickListener {

           //loop@ for (i in 1..100) {
            if (counter % 15 == 0) textView.text = "FizzBuzz"
            else if (counter % 3 == 0) textView.text = "Fizz"
            else if (counter % 5 == 0) textView.text = "Buzz"
            else textView.text = counter.toString()
       // }

            counter += 1
            counterView.text = "$counter"
        }




    }
}
