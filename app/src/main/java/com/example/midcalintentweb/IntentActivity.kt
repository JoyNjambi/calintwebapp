package com.example.midcalintentweb

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    //sms,call,dial,share,camera,stk(mpesa)

    lateinit var buttonsms:Button
    lateinit var buttonemail:Button
    lateinit var buttoncall:Button
    lateinit var buttondial:Button
    lateinit var buttonshare:Button
    lateinit var buttoncamera:Button
    lateinit var buttonmpesa:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        buttonsms=findViewById(R.id.Btn_sms)
        buttonemail=findViewById(R.id.Btn_email)
        buttoncall=findViewById(R.id.Btn_call)
        buttondial=findViewById(R.id.Btn_dial)
        buttonshare=findViewById(R.id.Btn_share)
        buttoncamera=findViewById(R.id.Btn_camera)
        buttonmpesa=findViewById(R.id.Button_mpesa)


        buttonsms.setOnClickListener {
            val uri = Uri.parse("smsto:07456789")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("Hello", "How is todays weather")

            startActivity(intent)
        }
        buttonemail.setOnClickListener {

            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
        buttondial.setOnClickListener {
            val phone = "+34666777888"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)

        }
        buttoncamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(takePictureIntent, 1)
        }

        buttoncall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
            buttonmpesa.setOnClickListener {
                val simToolKitLaunchIntent =
                    applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { startActivity(it) }
            }
            buttonshare.setOnClickListener {
                val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                shareIntent.type = "text/plain"

                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

                startActivity(shareIntent)
            }
        }
    }
}