package com.example.midcalintentweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {

    lateinit var Txt_answer: TextView
    lateinit var Edt_fnum: EditText
    lateinit var Edt_sndnum: EditText
    lateinit var Buttonadd: Button
    lateinit var buttonsibtract: Button
    lateinit var buttonmultiply: Button
    lateinit var buttondivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        Txt_answer = findViewById(R.id.Txt_ans)
        Edt_fnum = findViewById(R.id.Edt_Fnum)
        Edt_sndnum = findViewById(R.id.Edt_Sndnum)
        Buttonadd = findViewById(R.id.BTn_add)
        buttonsibtract = findViewById(R.id.Btn_subtract)
        buttonmultiply = findViewById(R.id.BTn_multiply)
        buttondivide = findViewById(R.id.Button_divide)


        Buttonadd.setOnClickListener {
            var myfirstnumber = Edt_fnum.text.toString()
            var mysecondnumber = Edt_sndnum.text.toString()


            //IF STATEMENT
            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty())
                Txt_answer.text = "Please input all the inputs"
            else {
                var answer = myfirstnumber.toDouble() + mysecondnumber.toDouble()
                Txt_answer.text = answer.toString()

            }
            buttonsibtract.setOnClickListener {
                var myfirstnumber = Edt_fnum.text.toString()
                var mysecondnumber = Edt_sndnum.text.toString()

                if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty())
                    Txt_answer.text = "Please input all the inputs"
                else {
                    var answer = myfirstnumber.toDouble() - mysecondnumber.toDouble()
                    Txt_answer.text = answer.toString()
                }
                buttonmultiply.setOnClickListener {
                    var myfirstnumber = Edt_fnum.text.toString()
                    var mysecondnumber = Edt_sndnum.text.toString()


                    if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty())
                        Txt_answer.text = "Please input all the inputs"
                    else {
                        var answer = myfirstnumber.toDouble() * mysecondnumber.toDouble()
                        Txt_answer.text = answer.toString()
                    }
                    buttondivide.setOnClickListener {
                        var myfirstnumber = Edt_fnum.text.toString()
                        var mysecondnumber = Edt_sndnum.text.toString()

                        if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty())
                            Txt_answer.text = "Please input all the inputs"
                        else {
                            var answer = myfirstnumber.toDouble() / mysecondnumber.toDouble()
                            Txt_answer.text = answer.toString()
                        }
                    }
                }
            }
        }

    }
}