package com.example.midcalintentweb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var ButtonCalc:Button
    lateinit var ButtonIntent:Button
    lateinit var Buttonweb:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButtonCalc=findViewById(R.id.Btn_Calc)
        ButtonCalc.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)


        ButtonIntent=findViewById(R.id.Btn_int)
        ButtonIntent.setOnClickListener {
            val intent=Intent(this,IntentActivity::class.java)
            startActivity(intent)

        Buttonweb=findViewById(R.id.Btn_web)
        Buttonweb.setOnClickListener {
                val intent=Intent(this,WebActivity::class.java)
                startActivity(intent)
        }
        }

    }
}
}